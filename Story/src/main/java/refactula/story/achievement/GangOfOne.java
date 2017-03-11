package refactula.story.achievement;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.quest.DesignPatterns;

import static refactula.story.markdown.MDElements.header;

public class GangOfOne extends Achievement {
    private final Header header = header("Gang of One");

    private DesignPatterns designPatterns;

    public void setDesignPatterns(DesignPatterns designPatterns) {
        this.designPatterns = designPatterns;
    }

    @Override
    protected MDLine getLine() {
        return MDLine.of("Has implemented all " + designPatterns.getHeader().getFormattedLink() + ".");
    }

    @Override
    public String getTaskLineLink() {
        return header.getFormattedLink();
    }

    @Override
    public Header getHeader() {
        return header;
    }
}
