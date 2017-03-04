package refactula.story.alternative.skill;

import refactula.story.alternative.Reward;
import refactula.story.alternative.markdown.MDLine;
import refactula.story.alternative.markdown.MDWriter;
import refactula.story.alternative.quest.Quest;

import java.util.HashSet;
import java.util.Set;

public abstract class Skill extends Reward {
    private int activations = 0;
    private Set<Quest> activatedQuests = new HashSet<>();

    @Override
    public void activate(Quest quest) {
        activations++;
        activatedQuests.add(quest);
    }

    protected final void writeActivations(MDWriter writer) {
        if (!activatedQuests.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("Proved by:");
            for (Quest quest : activatedQuests) {
                builder.append(' ').append(quest.getHeader().getFormattedLink());
            }
            writer.writeln(MDLine.of(builder.append('.').toString()));
        }
    }
}
