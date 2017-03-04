package refactula.story.alternative;

import refactula.story.alternative.markdown.Markdown;

public abstract class Reward implements Markdown {

    public abstract String getFormattedLink();

    public abstract void activate();

}
