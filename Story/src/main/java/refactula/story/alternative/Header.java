package refactula.story.alternative;

import com.google.common.base.Preconditions;

public class Header implements MDElement {
    private final int level;
    private final String text;

    public Header(int level, String text) {
        Preconditions.checkArgument(level > 0 && level <= 6);
        this.level = level;
        this.text = text;
    }

    public String getFormattedLink() {
        return Formatting.link("`" + text + "`", "#" + text.toLowerCase().replace(' ', '-'));
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
