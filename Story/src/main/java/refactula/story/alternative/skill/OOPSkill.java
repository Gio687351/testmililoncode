package refactula.story.alternative.skill;

import refactula.story.alternative.markdown.Formatting;
import refactula.story.alternative.markdown.Header;
import refactula.story.alternative.markdown.MDWriter;

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
    }

    @Override
    public void activate() {

    }
}
