package refactula.story.achievement;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.Quest;

public class GangOfOne extends Achievement {
    private final Header header = new Header(3, "Gang of One");

    @Override
    public String getFormattedLink() {
        return header.getFormattedLink();
    }

    @Override
    public void activate(Quest quest) {

    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(MDLine.of("Has implemented all design patterns."));
    }
}
