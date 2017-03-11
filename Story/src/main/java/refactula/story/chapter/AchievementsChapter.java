package refactula.story.chapter;

import refactula.story.achievement.Achievement;
import refactula.story.markdown.MDWriter;

import java.util.List;

import static refactula.story.markdown.MDElements.chapterTitle;

public class AchievementsChapter extends Chapter {
    private final List<Achievement> achievements;

    public AchievementsChapter(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(chapterTitle("Achievements"));
        for (Achievement achievement : achievements) {
            writer.write(achievement);
        }
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}
