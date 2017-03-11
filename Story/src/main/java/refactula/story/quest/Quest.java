package refactula.story.quest;

import refactula.story.markdown.DelayedMDWriter;
import refactula.story.markdown.Header;
import refactula.story.markdown.MDElements;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDParagraph;
import refactula.story.markdown.MDWriter;
import refactula.story.markdown.Markdown;
import refactula.story.Reward;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static refactula.story.markdown.MDElements.header;

public abstract class Quest implements Markdown {
    private final Header header;
    private final DelayedMDWriter delayedWriter = new DelayedMDWriter();
    private final List<Task> tasks = new ArrayList<>();

    protected Quest(String headerText) {
        this.header = header(headerText);
        writeln(header);
    }

    protected final void write(MDParagraph element) {
        delayedWriter.write(element);
    }

    protected final void writeln(MDParagraph line) {
        delayedWriter.writeln(line);
    }

    protected final void write(Markdown markdown) {
        delayedWriter.write(markdown);
    }

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

    public final Header getHeader() {
        return header;
    }

    @Override
    public final void writeTo(MDWriter writer) {
        delayedWriter.writeTo(writer);
    }

    public boolean isInProgress() {
        return hasTasks() && hasCompletedTasks() && !allTasksCompleted();
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
