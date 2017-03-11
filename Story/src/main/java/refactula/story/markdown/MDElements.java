package refactula.story.markdown;

public class MDElements {

    public static Header title(String text) {
        return new Header(1, text);
    }

    public static Header chapterTitle(String text) {
        return new Header(2, text);
    }

    public static Header header(String text) {
        return new Header(3, text);
    }

    public static Header subheader(String text) {
        return new Header(5, text);
    }

}
