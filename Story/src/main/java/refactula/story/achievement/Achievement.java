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
        writer.writeln(getHeader());
        writer.writeln(MDLine.of("* [" + (isGranted() ? "x" : " ") + "] " + getLine().toString()));
    }

    protected abstract MDLine getLine();

    public boolean isGranted() {
        return !activatedBy.isEmpty();
    }
}
