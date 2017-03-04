package refactula.story.markdown;

public class MDImage implements MDParagraph {
    private final String link;
    private final String altText;

    public MDImage(String link, String altText) {
        this.link = link;
        this.altText = altText;
    }

    @Override
    public MDLine toMDLine() {
        return MDLine.of("![" + altText + "](" + link + ")");
    }
}
