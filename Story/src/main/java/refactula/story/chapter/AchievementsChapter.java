package refactula.story.chapter;

import refactula.story.achievement.Achievement;
import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;

import java.util.List;

public class AchievementsChapter extends Chapter {
    private final List<Achievement> achievements;

    public AchievementsChapter(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(new Header(2, "Achievements"));
        for (Achievement achievement : achievements) {
            writer.write(achievement);
        }
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}
