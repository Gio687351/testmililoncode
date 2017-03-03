package refactula.story;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeadersTracker {
    private final HeaderParser parser = new HeaderParser();
    private final TokensList tokens = new TokensList();

    public void update(String line, HeaderTrackerListener listener) {
        parser.parse(line);
        if (parser.isHeader()) {
            openHeader(parser.getLevel(), parser.getText(), listener);
        }
    }

    public void endOfStream(HeaderTrackerListener listener) {
        closeExisting(0, listener);
    }

    private void openHeader(int level, String text, HeaderTrackerListener listener) {
        openParentPlaceholders(level);
        closeExisting(level, listener);
        openHeader(text, listener);
    }

    private void openHeader(String text, HeaderTrackerListener listener) {
        tokens.append(new Token(text));
        listener.onHeaderOpened(getLevels() - 1, text);
    }

    private void openParentPlaceholders(int level) {
        while (getLevels() < level) {
            openPlaceholder();
        }
    }

    private int getLevels() {
        return tokens.amount();
    }

    private void openPlaceholder() {
        tokens.append(Token.PLACEHOLDER);
    }

    private void closeExisting(int level, HeaderTrackerListener listener) {
        while (getLevels() > level) {
            closeLastLevel(listener);
        }
    }

    private void closeLastLevel(HeaderTrackerListener listener) {
        Token token = tokens.removeLast();
        if (!token.isPlaceholder()) {
            listener.onHeaderClosed(getLevels(), token.getText());
        }
    }

    private static final class Token {
        private final static Token PLACEHOLDER = new Token(true, null);

        private final boolean isPlaceholder;
        private final String text;

        private Token(String text) {
            this(false, text);
        }

        private Token(boolean isPlaceholder, String text) {
            this.isPlaceholder = isPlaceholder;
            this.text = text;
        }

        private boolean isPlaceholder() {
            return isPlaceholder;
        }

        private String getText() {
            return text;
        }
    }

    private static final class TokensList {
        private final List<Token> tokens = new ArrayList<>();

        private void append(Token token) {
            tokens.add(token);
        }

        private int amount() {
            return tokens.size();
        }

        private Token removeLast() {
            return tokens.remove(tokens.size() - 1);
        }
    }

    private static final class HeaderParser {
        private static final Pattern PATTERN = Pattern.compile("(#+) (.*)");

        private Matcher matcher;

        private void parse(String line) {
            matcher = PATTERN.matcher(line);
        }

        private boolean isHeader() {
            return matcher.matches();
        }

        private int getLevel() {
            return matcher.group(1).length() - 1;
        }

        private String getText() {
            return matcher.group(2);
        }
    }

    public interface HeaderTrackerListener {

        void onHeaderOpened(int level, String text);

        void onHeaderClosed(int level, String text);

    }
}
