package refactula.story;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import static refactula.story.Predicates.not;
import static refactula.story.Transform.transform;
import static refactula.story.Unchecked.function;

public class LinesCounter {
    private static final Function<String, Path> TO_PATH = Paths::get;
    private static final Function<Path, Stream<Path>> WALK = function(p -> Files.walk(p));
    private static final Predicate<Path> IS_JAVA_FILE = p -> p.toString().endsWith(".java");
    private static final Predicate<String> NOT_EMPTY = not(String::isEmpty);
    private static final Function<Path, Stream<String>> READ_LINES = function(Files::lines);
    private static final ToIntFunction<Object> ONE = o -> 1;

    public static int countLines() {
        return countLines(transform(userDir(), TO_PATH));
    }

    public static int countLines(Path path) {
        return transform(path, WALK)
                .filter(IS_JAVA_FILE)
                .flatMap(READ_LINES)
                .filter(NOT_EMPTY)
                .mapToInt(ONE)
                .sum();
    }

    private static String userDir() {
        return System.getProperty("user.dir");
    }
}
