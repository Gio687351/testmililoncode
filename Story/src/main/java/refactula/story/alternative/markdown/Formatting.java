package refactula.story.alternative.markdown;

import com.google.common.base.Preconditions;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Formatting {

    public static String bold(Object text) {
        return "**" + text + "**";
    }

    public static String link(String text, String address) {
        validateLink(address);
        return "[" + text + "](" + address + ")";
    }

    private static void validateLink(String link) {
        if (link.startsWith("http") || link.startsWith("#")) {
            return;
        }
        Preconditions.checkArgument(Files.exists(Paths.get(link)), "Path doesn't exist: %s", link);
    }

}
