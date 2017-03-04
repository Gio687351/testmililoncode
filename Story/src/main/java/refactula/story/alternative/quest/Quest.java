package refactula.story.alternative.quest;

import refactula.story.alternative.Reward;

public class Quest {

    public Task task(String text, Reward... rewards) {
        Task task = new Task(text, rewards);
        register(task);
        return task;
    }

    public Task done(String text, Reward... rewards) {
        return task(text, rewards).completed();
    }

    private void register(Task task) {

    }

}
