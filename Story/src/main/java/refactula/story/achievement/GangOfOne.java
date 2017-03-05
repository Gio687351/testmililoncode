package refactula.story.achievement;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;

public class GangOfOne extends Achievement {
    private final Header header = new Header(3, "Gang of One");

    @Override
    public String getTaskLineLink() {
        return header.getFormattedLink();
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    protected void writeContend(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(MDLine.of("Has implemented all design patterns."));
    }
}
