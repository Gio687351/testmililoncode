package refactula.story.chapter;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.Quest;

import java.util.List;

public class QuestsChapter extends Chapter {
    private final Header header = new Header(2, "Quests");
    private final List<Quest> quests;

    public QuestsChapter(List<Quest> quests) {
        this.quests = quests;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        for (Quest quest : quests) {
            writer.write(quest);
        }
    }

    public List<Quest> getQuests() {
        return quests;
    }
}
