package refactula.story.chapter;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;
import refactula.story.skill.ObjectOrientedProgramming;

public class SkillsChapter extends Chapter {
    private final ObjectOrientedProgramming objectOrientedProgramming;

    public SkillsChapter(ObjectOrientedProgramming objectOrientedProgramming) {
        this.objectOrientedProgramming = objectOrientedProgramming;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(new Header(2, "Skills"));
        writer.write(objectOrientedProgramming);
    }
}
