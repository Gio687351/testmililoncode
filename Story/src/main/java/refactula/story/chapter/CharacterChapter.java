package refactula.story.chapter;

import refactula.story.achievement.Achievement;
import refactula.story.markdown.Header;
import refactula.story.Hero;
import refactula.story.Level;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDImage;
import refactula.story.markdown.MDWriter;
import refactula.story.quest.Quest;
import refactula.story.skill.Skill;

import static refactula.story.markdown.Formatting.bold;

public class CharacterChapter extends Chapter {
    private final Header header = new Header(2, "Character");
    private final Hero hero;
    private final Level level;
    private final String progressBar;
    private final QuestsChapter questsChapter;
    private final SkillsChapter skillsChapter;
    private final AchievementsChapter achievementsChapter;

    public CharacterChapter(
            Hero hero,
            Level level,
            String progressBar,
            QuestsChapter questsChapter,
            SkillsChapter skillsChapter,
            AchievementsChapter achievementsChapter) {

        this.hero = hero;
        this.level = level;
        this.progressBar = progressBar;
        this.questsChapter = questsChapter;
        this.skillsChapter = skillsChapter;
        this.achievementsChapter = achievementsChapter;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(hero.getAvatar());
        writer.write(MDLine.joined("Name: " + bold(hero.getName())));
        writer.write(MDLine.joined("Level: " + bold(level.getLevel())));
        String progressPercents = String.format("%.2f%%", level.getProgress());
        writer.writeln(MDLine.joined("Progress: " + progressPercents
                + " (" + level.getCompleted() + "/" + level.getLines() + ")"));
        writer.writeln(new MDImage(progressBar, "Progress: " + progressPercents));
        writeOngoingQuests(writer);
        writeCompletedQuests(writer);
        writeAchievements(writer);
        writeSkills(writer);
    }

    private void writeAchievements(MDWriter writer) {
        boolean hasGranted = false;
        StringBuilder builder = new StringBuilder();
        builder.append("Achievements:");
        for (Achievement achievement : achievementsChapter.getAchievements()) {
            if (achievement.isGranted()) {
                hasGranted = true;
                builder.append(' ');
                builder.append(achievement.getHeader().getFormattedLink());
            }
        }
        if (hasGranted) {
            writer.writeln(MDLine.of(builder.toString()));
        }
    }

    private void writeSkills(MDWriter writer) {
        boolean hasActivated = false;
        StringBuilder builder = new StringBuilder();
        builder.append("Skills:");
        for (Skill skill : skillsChapter.getSkills()) {
            if (skill.isActivated()) {
                hasActivated = true;
                builder.append(' ');
                builder.append(skill.getCharacterChapterLink());
            }
        }
        if (hasActivated) {
            writer.writeln(MDLine.of(builder.toString()));
        }
    }

    private void writeOngoingQuests(MDWriter writer) {
        boolean hasInProgress = false;
        StringBuilder builder = new StringBuilder();
        builder.append("Ongoing Quests:");
        for (Quest quest : questsChapter.getQuests()) {
            if (quest.isInProgress()) {
                hasInProgress = true;
                builder.append(' ');
                builder.append(quest.getHeader().getFormattedLink());
            }
        }
        if (hasInProgress) {
            writer.writeln(MDLine.of(builder.toString()));
        }
    }

    private void writeCompletedQuests(MDWriter writer) {
        boolean hasCompleted = false;
        StringBuilder builder = new StringBuilder();
        builder.append("Completed Quests:");
        for (Quest quest : questsChapter.getQuests()) {
            if (quest.isCompleted()) {
                hasCompleted = true;
                builder.append(' ');
                builder.append(quest.getHeader().getFormattedLink());
            }
        }
        if (hasCompleted) {
            writer.writeln(MDLine.of(builder.toString()));
        }
    }
}
