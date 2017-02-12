package refactula.lambda;

import com.google.common.collect.ImmutableMap;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        Map<String, Integer> numbersMap = ImmutableMap.<String, Integer>builder()
                .put("zero", 0)
                .put("one", 1)
                .put("two", 2)
                .put("three", 3)
                .put("four", 4)
                .put("five", 5)
                .put("six", 6)
                .put("seven", 7)
                .put("eight", 8)
                .put("nine", 9)
                .build();

        Parser<Integer> numbersParser = s -> {
            Integer number = numbersMap.get(s.toLowerCase());
            if (number != null) {
                return number;
            }
            throw new RuntimeException("Sorry, failed to parse " + s);
        };

        Path numbersPath = Paths.get(Main.class.getClassLoader().getResource("numbers.txt").toURI());
        Files.lines(numbersPath)
                .map(numbersParser::parse)
                .forEach(System.out::println);
    }

    interface Parser<T> {
        T parse(String s);
    }

}
