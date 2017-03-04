package refactula.story.alternative.quest;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import refactula.story.alternative.markdown.MDParagraph;
import refactula.story.alternative.markdown.MDLine;
import refactula.story.alternative.Reward;

import java.util.List;

public class Task implements MDParagraph {
    private final String text;
    private final List<Reward> rewards;
    private boolean completed = false;

    public Task(String text, Reward... rewards) {
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
            reward.activate();
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
            builder.append(reward.getFormattedLink());
        }
        return MDLine.of(builder.toString());
    }
}
