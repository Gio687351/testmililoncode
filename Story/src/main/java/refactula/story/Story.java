package refactula.story;

import refactula.story.chapter.AchievementsChapter;
import refactula.story.chapter.CharacterChapter;
import refactula.story.chapter.QuestsChapter;
import refactula.story.chapter.SkillsChapter;
import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;
import refactula.story.markdown.Markdown;

import static refactula.story.markdown.MDElements.title;

public class Story implements Markdown {
    private final Header title = title("1 Million Lines of Code");
    private final CharacterChapter characterChapter;
    private final QuestsChapter questsChapter;
    private final SkillsChapter skillsChapter;
    private final AchievementsChapter achievementsChapter;

    public Story(
            CharacterChapter characterChapter,
            QuestsChapter questsChapter,
            SkillsChapter skillsChapter,
            AchievementsChapter achievementsChapter) {

        this.characterChapter = characterChapter;
        this.questsChapter = questsChapter;
        this.skillsChapter = skillsChapter;
        this.achievementsChapter = achievementsChapter;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(title);
        writer.write(characterChapter);
        writer.write(questsChapter);
        writer.write(skillsChapter);
        writer.write(achievementsChapter);
    }
}
