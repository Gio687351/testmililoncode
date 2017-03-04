package refactula.story.skill;

import refactula.story.markdown.Formatting;
import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;

public class OOPSkill extends Skill {
    private final Header header = new Header(3, "Object-Oriented Programming");

    public Header getHeader() {
        return header;
    }

    @Override
    public String getFormattedLink() {
        return Formatting.link("`+OOP`", header.getLinkAddress());
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writeActivations(writer);
    }
}
