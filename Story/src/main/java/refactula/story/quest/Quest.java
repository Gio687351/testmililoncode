package refactula.story.quest;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.markdown.Markdown;
import refactula.story.Reward;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Quest implements Markdown {
    private final List<Task> tasks = new ArrayList<>();

    public Task task(String text, Reward... rewards) {
        Task task = new Task(this, text, rewards);
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

    public abstract Header getHeader();

    protected void writeTasks(MDWriter writer) {
        writer.writeln(new Header(5, "Tasks"));
        for (Task task : tasks) {
            writer.write(task);
        }
        writer.write(MDLine.empty());
    }

    public boolean isInProgress() {
        return hasCompletedTasks();
    }

    public boolean isCompleted() {
        return hasTasks() && allTasksCompleted();
    }

    private boolean hasCompletedTasks() {
        return tasks.stream().anyMatch(Task::isCompleted);
    }

    private boolean hasTasks() {
        return !tasks.isEmpty();
    }

    private boolean allTasksCompleted() {
        return tasks.stream().allMatch(Task::isCompleted);
    }
}
