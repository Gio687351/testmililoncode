package refactula.story.markdown;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DelayedMDWriter {
    private final List<Consumer<MDWriter>> instructions = new ArrayList<>();

    public void write(MDParagraph element) {
        instructions.add(writer -> writer.write(element));
    }

    public void writeln(MDParagraph line) {
        instructions.add(writer -> writer.writeln(line));
    }

    public void write(Markdown markdown) {
        instructions.add(writer -> writer.write(markdown));
    }

    public void writeTo(MDWriter writer) {
        instructions.forEach(instruction -> instruction.accept(writer));
    }
}
