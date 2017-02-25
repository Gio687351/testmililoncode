package refactula.design.patterns.behavioral.command.mu_puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;

public class Console {
    final BufferedReader reader;
    final PrintWriter writer;

    public Console(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void println() {
        writer.println();
    }

    public void println(String s) {
        writer.println(s);
    }

    public void flush() {
        writer.flush();
    }

    public void print(String s) {
        writer.print(s);
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
