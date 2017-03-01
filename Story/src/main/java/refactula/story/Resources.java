package refactula.story;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

import static refactula.story.Transform.transform;
import static refactula.story.Unchecked.function;

public class Resources {
    private static final ClassLoader CLASS_LOADER = Resources.class.getClassLoader();
    private static final Function<String, URL> TO_URL = CLASS_LOADER::getResource;
    private static final Function<URL, URI> TO_URI = function(URL::toURI);
    private static final Function<URI, Path> TO_PATH = Paths::get;
    private static final Function<Path, List<String>> TO_LINES = function(Files::readAllLines);
    
    public static List<String> readLines(String resourceName) {
        return transform(resourceName, TO_URL, TO_URI, TO_PATH, TO_LINES);
    }
}
