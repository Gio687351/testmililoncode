package refactula.story.skill;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDElements;
import refactula.story.markdown.MDWriter;

import static refactula.story.markdown.Formatting.link;
import static refactula.story.markdown.Formatting.mono;
import static refactula.story.markdown.MDElements.header;

public class Algorithms extends Skill {
    private final Header header = header("Algorithms");

    @Override
    public String getTaskLineLink() {
        return link(mono("+Algorithms"), header.getLinkAddress());
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
