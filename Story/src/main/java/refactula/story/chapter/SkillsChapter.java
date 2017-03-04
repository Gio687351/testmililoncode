package refactula.story.chapter;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;
import refactula.story.skill.OOPSkill;

public class SkillsChapter extends Chapter {
    private final OOPSkill oopSkill;

    public SkillsChapter(OOPSkill oopSkill) {
        this.oopSkill = oopSkill;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(new Header(2, "Skills"));
        writer.write(oopSkill);
    }
}
