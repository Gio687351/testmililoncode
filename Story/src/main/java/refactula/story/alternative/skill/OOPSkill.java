package refactula.story.alternative.skill;

import refactula.story.alternative.markdown.Header;
import refactula.story.alternative.markdown.MDWriter;

public class OOPSkill extends Skill {
    private final Header header = new Header(5, "Object Oriented Programming");

    public Header getHeader() {
        return header;
    }

    @Override
    public String getFormattedLink() {
        return header.getFormattedLink();
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
    }

    @Override
    public void activate() {

    }
}
