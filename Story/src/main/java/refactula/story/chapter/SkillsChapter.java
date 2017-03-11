package refactula.story.chapter;

import refactula.story.markdown.MDWriter;
import refactula.story.skill.Skill;

import java.util.List;

import static refactula.story.markdown.MDElements.chapterTitle;

public class SkillsChapter extends Chapter {
    private final List<Skill> skills;

    public SkillsChapter(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(chapterTitle("Skills"));
        for (Skill skill : skills) {
            writer.write(skill);
        }
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
