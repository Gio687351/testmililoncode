package refactula.story;

import refactula.story.achievement.GangOfOne;
import refactula.story.achievement.LetTheJourneyBegin;
import refactula.story.chapter.AchievementsChapter;
import refactula.story.chapter.CharacterChapter;
import refactula.story.chapter.QuestsChapter;
import refactula.story.chapter.SkillsChapter;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.DesignPatterns;
import refactula.story.quest.StoryTeller;
import refactula.story.skill.ObjectOrientedProgramming;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class StoryApp {

    public static void main(String[] args) throws IOException {
        // TODO: replace with dependency injection.
        Hero hero = new Hero("Refactula", "Vlad the Refactula");
        int lines = LinesCounter.countLines();
        LevelCalculator levelCalculator = new LevelCalculator(100, 200);
        int levelIndex = levelCalculator.getLevel(lines);
        int completed = lines - levelCalculator.getLinesBeforeCompleted(levelIndex);
        int levelLines = levelCalculator.getLinesToComplete(levelIndex);
        Level level = new Level(levelIndex, completed, levelLines);
        String progressBar = "Story/files/progress-bar.png";
        ObjectOrientedProgramming objectOrientedProgramming = new ObjectOrientedProgramming();
        LetTheJourneyBegin letTheJourneyBegin = new LetTheJourneyBegin();
        GangOfOne gangOfOne = new GangOfOne();
        StoryTeller storyTeller = new StoryTeller(objectOrientedProgramming, letTheJourneyBegin);
        DesignPatterns designPatterns = new DesignPatterns(objectOrientedProgramming, gangOfOne);
        QuestsChapter questsChapter = new QuestsChapter(storyTeller, designPatterns);
        SkillsChapter skillsChapter = new SkillsChapter(objectOrientedProgramming);
        AchievementsChapter achievementsChapter = new AchievementsChapter(letTheJourneyBegin, gangOfOne);
        CharacterChapter characterChapter = new CharacterChapter(hero, level, progressBar);
        Story story = new Story(characterChapter, questsChapter, skillsChapter, achievementsChapter);
        new ProgressBarPainter().draw(1.0 * completed / levelLines, Paths.get(progressBar).toFile());
        try (MDWriter mdWriter = new MDWriter(new PrintWriter(new FileWriter("README.md")))) {
            mdWriter.write(story);
        }
    }

}
