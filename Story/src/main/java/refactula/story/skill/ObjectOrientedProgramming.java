package refactula.story.skill;

import refactula.story.markdown.Formatting;
import refactula.story.markdown.Header;
import refactula.story.markdown.MDElements;
import refactula.story.markdown.MDWriter;

import static refactula.story.markdown.MDElements.header;

public class ObjectOrientedProgramming extends Skill {
    private final Header header = header("Object-Oriented Programming");

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public String getTaskLineLink() {
        return Formatting.link("`+OOP`", header.getLinkAddress());
    }

    @Override
    protected void writeContent(MDWriter writer) {
        writer.writeln(header);
    }
}
