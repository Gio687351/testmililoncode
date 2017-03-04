package refactula.story.alternative;

public class MDAdvancedImage implements MDElement {
    private final String src;
    private final String width;

    public MDAdvancedImage(String src, String width) {
        this.src = src;
        this.width = width;
    }

    @Override
    public MDLine toMDLine() {
        return MDLine.of("<img src=\"" + src + "\" width=\"" + width + "\"/>");
    }
}
