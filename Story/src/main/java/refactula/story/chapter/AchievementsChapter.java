package refactula.story.chapter;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;
import refactula.story.achievement.GangOfOne;

public class AchievementsChapter extends Chapter {
    private final GangOfOne gangOfOne;

    public AchievementsChapter(GangOfOne gangOfOne) {
        this.gangOfOne = gangOfOne;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(new Header(2, "Achievements"));
        writer.write(gangOfOne);
    }
}
