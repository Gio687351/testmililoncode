package refactula.story.skill;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDWriter;

import static refactula.story.markdown.Formatting.link;

public class Algorithms extends Skill {
    private final Header header = new Header(3, "Algorithms");

    @Override
    public String getTaskLineLink() {
        return link("+Algorithms", header.getLinkAddress());
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    protected void writeContent(MDWriter writer) {
        writer.writeln(header);
    }
}
