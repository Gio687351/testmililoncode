package refactula.story;

import refactula.story.markdown.Markdown;
import refactula.story.quest.Quest;

public abstract class Reward implements Markdown {

    public abstract String getFormattedLink();

    public abstract void activate(Quest quest);

}
