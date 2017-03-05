package refactula.story.achievement;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.StoryTeller;

public class LetTheJourneyBegin extends Achievement {
    private final Header header = new Header(3, "Let the Journey Begin");

    private StoryTeller storyTeller;

    public void setStoryTeller(StoryTeller storyTeller) {
        this.storyTeller = storyTeller;
    }

    @Override
    protected void writeContend(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(MDLine.of("Has completed " + storyTeller.getHeader().getFormattedLink() + " quest."));
    }

    @Override
    public String getFormattedLink() {
        return header.getFormattedLink();
    }
}
