package refactula.story.chapter;

import refactula.story.achievement.GangOfOne;
import refactula.story.achievement.LetTheJourneyBegin;
import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;

public class AchievementsChapter extends Chapter {
    private final LetTheJourneyBegin letTheJourneyBegin;
    private final GangOfOne gangOfOne;

    public AchievementsChapter(LetTheJourneyBegin letTheJourneyBegin, GangOfOne gangOfOne) {
        this.letTheJourneyBegin = letTheJourneyBegin;
        this.gangOfOne = gangOfOne;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(new Header(2, "Achievements"));
        writer.write(letTheJourneyBegin);
        writer.write(gangOfOne);
    }
}
