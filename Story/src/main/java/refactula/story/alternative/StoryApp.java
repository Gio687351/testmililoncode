package refactula.story.alternative;

import refactula.story.LevelCalculator;
import refactula.story.LinesCounter;
import refactula.story.alternative.achievement.GangOfOne;
import refactula.story.alternative.chapter.AchievementsChapter;
import refactula.story.alternative.chapter.CharacterChapter;
import refactula.story.alternative.chapter.QuestsChapter;
import refactula.story.alternative.chapter.SkillsChapter;
import refactula.story.alternative.markdown.MDWriter;
import refactula.story.alternative.quest.DesignPatterns;
import refactula.story.alternative.skill.OOPSkill;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StoryApp {

    public static void main(String[] args) throws IOException {
        Hero hero = new Hero("Refactula", "Vlad the Refactula");
        int lines = LinesCounter.countLines();
        LevelCalculator levelCalculator = new LevelCalculator(100, 200);
        int levelIndex = levelCalculator.getLevel(lines);
        int completed = lines - levelCalculator.getLinesBeforeCompleted(levelIndex);
        int levelLines = levelCalculator.getLinesToComplete(levelIndex);
        Level level = new Level(levelIndex, completed, levelLines);
        CharacterChapter characterChapter = new CharacterChapter(hero, level, "ProgressBar/export/Progress.png");
        OOPSkill oopSkill = new OOPSkill();
        GangOfOne gangOfOne = new GangOfOne();
        QuestsChapter questsChapter = new QuestsChapter(new DesignPatterns(oopSkill, gangOfOne));
        Story story = new Story(characterChapter, questsChapter, new SkillsChapter(oopSkill), new AchievementsChapter(gangOfOne));
        try (MDWriter mdWriter = new MDWriter(new PrintWriter(new FileWriter("README.md")))) {
            mdWriter.write(story);
        }
    }

}
