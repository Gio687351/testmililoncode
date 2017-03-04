package refactula.story;

import refactula.story.achievement.GangOfOne;
import refactula.story.chapter.AchievementsChapter;
import refactula.story.chapter.CharacterChapter;
import refactula.story.chapter.QuestsChapter;
import refactula.story.chapter.SkillsChapter;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.DesignPatterns;
import refactula.story.skill.OOPSkill;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class StoryApp {

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero("Refactula", "Vlad the Refactula");
        int lines = LinesCounter.countLines();
        LevelCalculator levelCalculator = new LevelCalculator(100, 200);
        int levelIndex = levelCalculator.getLevel(lines);
        int completed = lines - levelCalculator.getLinesBeforeCompleted(levelIndex);
        int levelLines = levelCalculator.getLinesToComplete(levelIndex);
        Level level = new Level(levelIndex, completed, levelLines);
        String progressBar = "Story/files/progress-bar.png";
        CharacterChapter characterChapter = new CharacterChapter(hero, level, progressBar);
        OOPSkill oopSkill = new OOPSkill();
        GangOfOne gangOfOne = new GangOfOne();
        QuestsChapter questsChapter = new QuestsChapter(new DesignPatterns(oopSkill, gangOfOne));
        Story story = new Story(characterChapter, questsChapter, new SkillsChapter(oopSkill), new AchievementsChapter(gangOfOne));
        new ProgressBarPainter().draw(1.0 * completed / levelLines, Paths.get(progressBar).toFile());
        try (MDWriter mdWriter = new MDWriter(new PrintWriter(new FileWriter("README.md")))) {
            mdWriter.write(story);
        }
    }

}
