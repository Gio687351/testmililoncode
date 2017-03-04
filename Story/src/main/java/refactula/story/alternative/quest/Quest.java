package refactula.story.alternative.quest;

import refactula.story.alternative.markdown.Markdown;
import refactula.story.alternative.Reward;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Quest implements Markdown {
    private final List<Task> tasks = new ArrayList<>();

    public Task task(String text, Reward... rewards) {
        Task task = new Task(text, rewards);
        register(task);
        return task;
    }

    public Task done(String text, Reward... rewards) {
        Task task = task(text, rewards);
        task.onCompleted();
        return task;
    }

    private void register(Task task) {
        tasks.add(task);
    }

    public Collection<Reward> getGainedRewards() {
        ArrayList<Reward> rewards = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                rewards.addAll(task.getRewards());
            }
        }
        return rewards;
    }
}
