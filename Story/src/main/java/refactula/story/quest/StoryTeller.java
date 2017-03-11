package refactula.story.quest;

import refactula.story.achievement.LetTheJourneyBegin;
import refactula.story.markdown.MDLine;
import refactula.story.skill.ObjectOrientedProgramming;

import static refactula.story.markdown.Formatting.italic;
import static refactula.story.markdown.Formatting.link;
import static refactula.story.markdown.Formatting.mono;
import static refactula.story.markdown.MDElements.subheader;

public class StoryTeller extends Quest {

    public StoryTeller(ObjectOrientedProgramming objectOrientedProgramming, LetTheJourneyBegin letTheJourneyBegin) {
        super("Story Teller");
        letTheJourneyBegin.setStoryTeller(this);

        writeln(MDLine.of("Create a program that turns this " + italic("1 Million Lines of Code") + " challenge into " +
                "an RPG-style journey with levels, quests, skills and achievements."));

        writeln(subheader("Tasks"));
        write(done("Implement " + mono("Markdown") + " support", objectOrientedProgramming));
        write(done("Implement Quests", objectOrientedProgramming));
        write(done("Implement Achievements", objectOrientedProgramming));
        write(done("Implement Skills", objectOrientedProgramming));
        write(done("Implement Character summary", objectOrientedProgramming));
        writeln(done(link("Complete the quest", "Story/src/main/java/refactula/story"), letTheJourneyBegin));
    }

}
