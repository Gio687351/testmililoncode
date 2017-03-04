package refactula.story.alternative;

public class Formatting {

    public static String bold(Object text) {
        return "**" + text + "**";
    }

    public static String link(String text, String address) {
        return "[" + text + "](" + address + ")";
    }

}
