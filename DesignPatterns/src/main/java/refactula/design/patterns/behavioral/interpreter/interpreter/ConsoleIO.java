package refactula.design.patterns.behavioral.interpreter.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UncheckedIOException;

public class ConsoleIO implements IO {
    private final BufferedReader reader;
    private final PrintWriter writer;

    public static ConsoleIO systemIO() {
        return new ConsoleIO(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));
    }

    public ConsoleIO(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void show(String text) {
        writer.println(text);
        writer.flush();
    }

    @Override
    public String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
