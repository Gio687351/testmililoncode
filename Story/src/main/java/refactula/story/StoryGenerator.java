package refactula.story;

import refactula.story.HeadersTracker.HeaderTrackerListener;

import java.util.List;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static refactula.story.Resources.readLines;

public class StoryGenerator {

    public static void main(String[] args) throws Exception {
        List<String> sourceLines = readLines("Source.md");
        LevelCalculator levelCalculator = new LevelCalculator(100, 200);
        Bindings bindings = levelCalculator
                .getProgress(LinesCounter.countLines())
                .bind(new Bindings());

        List<String> story = sourceLines
                .stream()
                .map(bindings::enhance)
                .collect(toImmutableList());

        story.forEach(System.out::println);

        HeaderTrackerListener listener = new HeaderTrackerListener() {
            public void onHeaderOpened(int level, String text) {
                printWhitespaces(level);
                System.out.println("Opened H" + (level + 1) + ": " + text);
            }

            public void onHeaderClosed(int level, String text) {
                printWhitespaces(level);
                System.out.println("Closed H" + (level + 1) + ": " + text);
            }

            private void printWhitespaces(int amount) {
                for (int i = 0; i < amount; i++) {
                    System.out.print(" ");
                }
            }
        };

        HeadersTracker headersTracker = new HeadersTracker();
        for (int lineIndex = 0; lineIndex < story.size(); lineIndex++) {
            String line = story.get(lineIndex);
            headersTracker.update(line, listener);
        }
        headersTracker.endOfStream(listener);
    }

}
