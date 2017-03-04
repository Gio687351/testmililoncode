package refactula.story.alternative;

import refactula.story.alternative.markdown.Markdown;
import refactula.story.alternative.quest.Quest;

public abstract class Reward implements Markdown {

    public abstract String getFormattedLink();

    public abstract void activate(Quest quest);

}
