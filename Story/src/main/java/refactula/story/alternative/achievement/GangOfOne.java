package refactula.story.alternative.achievement;

import refactula.story.alternative.markdown.Header;
import refactula.story.alternative.markdown.MDLine;
import refactula.story.alternative.markdown.MDWriter;

public class GangOfOne extends Achievement {
    private final Header header = new Header(3, "Gang of One");

    @Override
    public String getFormattedLink() {
        return header.getFormattedLink();
    }

    @Override
    public void activate() {

    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(MDLine.of("Has implemented all design patterns."));
    }
}
