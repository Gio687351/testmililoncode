package refactula.story.achievement;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.quest.StoryTeller;

import static refactula.story.markdown.MDElements.header;

public class LetTheJourneyBegin extends Achievement {
    private final Header header = header("Let the Journey Begin");

    private StoryTeller storyTeller;

    public void setStoryTeller(StoryTeller storyTeller) {
        this.storyTeller = storyTeller;
    }

    @Override
    protected MDLine getLine() {
        return MDLine.of("Has completed " + storyTeller.getHeader().getFormattedLink() + " quest.");
    }

    @Override
    public String getTaskLineLink() {
        return header.getFormattedLink();
    }

    @Override
    public Header getHeader() {
        return header;
    }
}
