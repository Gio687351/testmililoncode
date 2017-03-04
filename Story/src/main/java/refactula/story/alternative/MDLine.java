package refactula.story.alternative;

import com.google.common.base.Preconditions;

public class MDLine implements MDElement {
    private final String text;

    public static MDLine of(String text) {
        return new MDLine(text);
    }

    public static MDLine joined(String text) {
        return of(text + "  ");
    }

    private MDLine(String text) {
        Preconditions.checkArgument(!text.contains("\n"));
        this.text = text;
    }

    @Override
    public MDLine toMDLine() {
        return this;
    }

    @Override
    public String toString() {
        return text;
    }
}
