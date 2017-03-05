package refactula.story.chapter;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.DesignPatterns;
import refactula.story.quest.StoryTeller;

public class QuestsChapter extends Chapter {
    private final Header header = new Header(2, "Quests");

    private final StoryTeller storyTeller;
    private final DesignPatterns designPatterns;

    public QuestsChapter(StoryTeller storyTeller, DesignPatterns designPatterns) {
        this.storyTeller = storyTeller;
        this.designPatterns = designPatterns;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writer.write(storyTeller);
        writer.write(designPatterns);
    }
}
