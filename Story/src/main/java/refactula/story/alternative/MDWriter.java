package refactula.story.alternative;

import java.io.PrintWriter;

public class MDWriter {
    private final PrintWriter writer;

    public MDWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public void write(MDElement element) {
        writer.println(element.toMDLine().toString());
    }

    public void writeln(MDElement line) {
        write(line);
        writer.println();
    }
}
