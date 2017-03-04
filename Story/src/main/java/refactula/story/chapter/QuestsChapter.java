package refactula.story.chapter;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.DesignPatterns;

public class QuestsChapter extends Chapter {
    private final Header header = new Header(2, "Quests");

    private final DesignPatterns designPatterns;

    public QuestsChapter(DesignPatterns designPatterns) {
        this.designPatterns = designPatterns;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writer.write(designPatterns);
    }
}
