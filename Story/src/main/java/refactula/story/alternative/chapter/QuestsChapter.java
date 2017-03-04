package refactula.story.alternative.chapter;

import refactula.story.alternative.Header;
import refactula.story.alternative.MDWriter;
import refactula.story.alternative.quest.DesignPatterns;

public class QuestsChapter {
    private final Header header = new Header(2, "Quests");

    private final DesignPatterns designPatterns;

    public QuestsChapter(DesignPatterns designPatterns) {
        this.designPatterns = designPatterns;
    }

    public void write(MDWriter writer) {
        writer.writeln(header);
        designPatterns.write(writer);
    }
}
