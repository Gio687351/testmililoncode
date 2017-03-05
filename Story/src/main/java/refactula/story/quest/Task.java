package refactula.story.quest;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import refactula.story.markdown.MDParagraph;
import refactula.story.markdown.MDLine;
import refactula.story.Reward;

import java.util.List;

public class Task implements MDParagraph {
    private final Quest quest;
    private final String text;
    private final List<Reward> rewards;
    private boolean completed = false;

    public Task(Quest quest, String text, Reward... rewards) {
        this.quest = quest;
        this.text = text;
        this.rewards = ImmutableList.copyOf(rewards);
    }

    public boolean isCompleted() {
        return completed;
    }

    public void onCompleted() {
        Preconditions.checkState(!completed);
        completed = true;
        for (Reward reward : rewards) {
            reward.activate(quest);
        }
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    @Override
    public MDLine toMDLine() {
        StringBuilder builder = new StringBuilder();
        builder.append("* [");
        builder.append(completed ? 'x' : ' ');
        builder.append("] ");
        builder.append(text);;
        for (Reward reward : rewards) {
            builder.append(' ');
            builder.append(reward.getTaskLineLink());
        }
        return MDLine.of(builder.toString());
    }
}
