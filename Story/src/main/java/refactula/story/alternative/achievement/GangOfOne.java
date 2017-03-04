package refactula.story.alternative.achievement;

import refactula.story.alternative.Header;
import refactula.story.alternative.MDLine;
import refactula.story.alternative.MDWriter;

public class GangOfOne extends Achievement {
    private final Header header = new Header(3, "Gang of One");

    public void write(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(MDLine.of("Has implemented all design patterns."));
    }

    @Override
    public String getFormattedLink() {
        return header.getFormattedLink();
    }

    @Override
    public void activate() {

    }
}
