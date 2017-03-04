package refactula.story.alternative;

import refactula.story.alternative.chapter.AchievementsChapter;
import refactula.story.alternative.chapter.CharacterChapter;
import refactula.story.alternative.chapter.QuestsChapter;
import refactula.story.alternative.chapter.SkillsChapter;
import refactula.story.alternative.markdown.Header;
import refactula.story.alternative.markdown.MDWriter;
import refactula.story.alternative.markdown.Markdown;

public class Story implements Markdown {
    private final Header title = new Header(1, "1 Million Lines of Code");
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
