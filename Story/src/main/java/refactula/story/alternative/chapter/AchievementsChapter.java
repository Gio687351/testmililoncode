package refactula.story.alternative.chapter;

import refactula.story.alternative.Header;
import refactula.story.alternative.MDWriter;
import refactula.story.alternative.achievement.GangOfOne;

public class AchievementsChapter {
    private final GangOfOne gangOfOne;

    public AchievementsChapter(GangOfOne gangOfOne) {
        this.gangOfOne = gangOfOne;
    }

    public void write(MDWriter writer) {
        writer.writeln(new Header(2, "Achievements"));
        gangOfOne.write(writer);
    }
}
