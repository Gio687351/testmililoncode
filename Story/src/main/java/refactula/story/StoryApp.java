package refactula.story;

import com.google.common.collect.ImmutableList;
import refactula.story.achievement.GangOfOne;
import refactula.story.achievement.LetTheJourneyBegin;
import refactula.story.chapter.AchievementsChapter;
import refactula.story.chapter.CharacterChapter;
import refactula.story.chapter.QuestsChapter;
import refactula.story.chapter.SkillsChapter;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.DesignPatterns;
import refactula.story.quest.IntroductionToAlgorithms;
import refactula.story.quest.StoryTeller;
import refactula.story.skill.Algorithms;
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
        Algorithms algorithms = new Algorithms();
        IntroductionToAlgorithms introductionToAlgorithms = new IntroductionToAlgorithms(algorithms);
        QuestsChapter questsChapter = new QuestsChapter(ImmutableList.of(
                storyTeller,
                designPatterns,
                introductionToAlgorithms));

        SkillsChapter skillsChapter = new SkillsChapter(ImmutableList.of(objectOrientedProgramming, algorithms));
        AchievementsChapter achievementsChapter = new AchievementsChapter(ImmutableList.of(
                letTheJourneyBegin,
                gangOfOne));

        CharacterChapter characterChapter = new CharacterChapter(
                hero,
                level,
                progressBar,
                questsChapter,
                skillsChapter,
                achievementsChapter);

        Story story = new Story(characterChapter, questsChapter, skillsChapter, achievementsChapter);
        new ProgressBarPainter().draw(1.0 * completed / levelLines, Paths.get(progressBar).toFile());
        try (MDWriter mdWriter = new MDWriter(new PrintWriter(new FileWriter("README.md")))) {
            mdWriter.write(story);
        }
    }

}
