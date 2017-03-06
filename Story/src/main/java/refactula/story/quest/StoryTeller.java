package refactula.story.quest;

import refactula.story.achievement.LetTheJourneyBegin;
import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.skill.ObjectOrientedProgramming;

import static refactula.story.markdown.Formatting.italic;
import static refactula.story.markdown.Formatting.link;
import static refactula.story.markdown.Formatting.mono;

public class StoryTeller extends Quest {
    private final Header header = new Header(3, "Story Teller");

    public StoryTeller(ObjectOrientedProgramming objectOrientedProgramming, LetTheJourneyBegin letTheJourneyBegin) {
        letTheJourneyBegin.setStoryTeller(this);
        done("Implement " + mono("Markdown") + " support", objectOrientedProgramming);
        done("Implement Quests", objectOrientedProgramming);
        done("Implement Achievements", objectOrientedProgramming);
        done("Implement Skills", objectOrientedProgramming);
        done("Implement Character summary", objectOrientedProgramming);
        done(link("Complete the quest", "Story/src/main/java/refactula/story"), letTheJourneyBegin);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(MDLine.of("Create a program that turns this " + italic("1 Million Lines of Code")
                + " challenge into an RPG-style journey with levels, quests, skills and achievements."));
        writeTasks(writer);
    }
}
