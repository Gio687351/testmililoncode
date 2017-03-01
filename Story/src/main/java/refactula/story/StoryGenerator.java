package refactula.story;

import java.util.List;

import static refactula.story.Resources.readLines;

public class StoryGenerator {

    public static void main(String[] args) throws Exception {
        List<String> sourceLines = readLines("Source.md");
        int linesOfCode = LinesCounter.countLines();

    }

}
