package refactula.story;

import com.google.common.base.Preconditions;
import refactula.story.HeadersTracker.HeaderTrackerListener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        HeaderCollector collector = new HeaderCollector();
        HeadersTracker.traverse(story, collector);

        collector.headers.forEach(System.out::println);
    }

    private static final class HeaderCollector implements HeaderTrackerListener {
        private final Set<String> headers = new HashSet<String>();

        @Override
        public void onHeaderOpened(int level, String text) {
            if (level > 3) {
                return;
            }
            Preconditions.checkState(!headers.contains(text), "Duplicated header: " + text);
            headers.add(text);
        }

        @Override
        public void onHeaderClosed(int level, String text) {

        }
    }

}
