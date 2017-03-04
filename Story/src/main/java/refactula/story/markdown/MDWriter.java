package refactula.story.markdown;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;

public class MDWriter implements Closeable {
    private final PrintWriter writer;

    public MDWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public void write(MDParagraph element) {
        writer.println(element.toMDLine().toString());
    }

    public void writeln(MDParagraph line) {
        write(line);
        writer.println();
    }

    public void write(Markdown markdown) {
        markdown.writeTo(this);
    }

    public void flush() {
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
