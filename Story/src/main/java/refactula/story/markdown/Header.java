package refactula.story.markdown;

import com.google.common.base.Preconditions;

import static refactula.story.markdown.Formatting.link;
import static refactula.story.markdown.Formatting.mono;

public class Header implements MDParagraph {
    private final int level;
    private final String text;

    public Header(int level, String text) {
        Preconditions.checkArgument(level > 0 && level <= 6);
        this.level = level;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getFormattedLink() {
        return link(mono(text), getLinkAddress());
    }

    public String getLinkAddress() {
        return "#" + text.toLowerCase().replace(' ', '-');
    }

    @Override
    public MDLine toMDLine() {
        return MDLine.of(appendHashes(new StringBuilder()).append(' ').append(text).toString());
    }

    private StringBuilder appendHashes(StringBuilder builder) {
        for (int i = 0; i < level; i++) {
            builder.append('#');
        }
        return builder;
    }
}
