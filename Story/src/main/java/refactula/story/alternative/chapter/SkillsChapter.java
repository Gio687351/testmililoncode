package refactula.story.alternative.chapter;

import refactula.story.alternative.Header;
import refactula.story.alternative.MDWriter;
import refactula.story.alternative.skill.OOPSkill;

public class SkillsChapter {
    private final OOPSkill oopSkill;

    public SkillsChapter(OOPSkill oopSkill) {
        this.oopSkill = oopSkill;
    }

    public void write(MDWriter writer) {
        writer.writeln(new Header(2, "Skills"));
        oopSkill.write(writer);
    }
}
