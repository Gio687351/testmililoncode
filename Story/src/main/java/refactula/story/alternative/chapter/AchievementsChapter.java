package refactula.story.alternative.chapter;

import refactula.story.alternative.markdown.Header;
import refactula.story.alternative.markdown.MDWriter;
import refactula.story.alternative.achievement.GangOfOne;

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
