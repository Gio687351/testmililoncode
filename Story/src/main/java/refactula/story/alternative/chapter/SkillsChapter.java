package refactula.story.alternative.chapter;

import refactula.story.alternative.markdown.Header;
import refactula.story.alternative.markdown.MDWriter;
import refactula.story.alternative.skill.OOPSkill;

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
