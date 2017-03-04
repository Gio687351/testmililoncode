package refactula.story.alternative;

public class MDImage implements MDElement {
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
