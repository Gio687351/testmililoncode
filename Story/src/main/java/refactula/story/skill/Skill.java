package refactula.story.skill;

import com.google.common.collect.ImmutableList;
import refactula.story.Reward;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.Quest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static refactula.story.markdown.Formatting.link;
import static refactula.story.markdown.Formatting.mono;

public abstract class Skill extends Reward {
    private Map<Quest, Integer> activatedQuests = new HashMap<>();

    @Override
    public void activate(Quest quest) {
        activatedQuests.put(quest, activatedQuests.getOrDefault(quest, 0) + 1);
    }

    @Override
    public final void writeTo(MDWriter writer) {
        writeContent(writer);
        writeActivations(writer);
    }

    protected abstract void writeContent(MDWriter writer);

    private void writeActivations(MDWriter writer) {
        if (!activatedQuests.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("Proved by:");

            List<Entry<Quest, Integer>> sorted = activatedQuests.entrySet().stream()
                    .sorted(Comparator.comparingInt(Entry::getValue))
                    .collect(ImmutableList.toImmutableList());

            for (int i = sorted.size() - 1; i >= 0; i--) {
                Entry<Quest, Integer> entry = sorted.get(i);
                Quest quest = entry.getKey();
                int activations = entry.getValue();
                String text = quest.getHeader().getText() + " (" + activations + ")";
                builder.append(' ').append(link(mono(text), quest.getHeader().getLinkAddress()));
            }
            writer.writeln(MDLine.of(builder.append('.').toString()));
        }
    }
}
