package refactula.story.alternative;

import refactula.story.alternative.chapter.AchievementsChapter;
import refactula.story.alternative.chapter.CharacterChapter;
import refactula.story.alternative.chapter.QuestsChapter;
import refactula.story.alternative.chapter.SkillsChapter;

public class Story {
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

    public void print(MDWriter writer) {
        writer.writeln(title);
        characterChapter.print(writer);
        questsChapter.write(writer);
        skillsChapter.write(writer);
        achievementsChapter.write(writer);
    }
}
