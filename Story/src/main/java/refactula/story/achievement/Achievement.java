package refactula.story.achievement;

import refactula.story.Reward;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.Quest;

import java.util.HashSet;
import java.util.Set;

public abstract class Achievement extends Reward {
    private final Set<Quest> activatedBy = new HashSet<>();

    @Override
    public void activate(Quest quest) {
        activatedBy.add(quest);
    }

    @Override
    public final void writeTo(MDWriter writer) {
        writeContend(writer);
        writeGrantedBy(writer);
    }

    protected abstract void writeContend(MDWriter writer);

    private void writeGrantedBy(MDWriter writer) {
        if (!activatedBy.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("Granted by:");
            for (Quest quest : activatedBy) {
                builder.append(' ').append(quest.getHeader().getFormattedLink());
            }
            writer.writeln(MDLine.of(builder.append('.').toString()));
        }
    }

    public boolean isGranted() {
        return !activatedBy.isEmpty();
    }
}
