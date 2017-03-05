package refactula.story.chapter;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;
import refactula.story.skill.Skill;

import java.util.List;

public class SkillsChapter extends Chapter {
    private final List<Skill> skills;

    public SkillsChapter(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(new Header(2, "Skills"));
        for (Skill skill : skills) {
            writer.write(skill);
        }
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
