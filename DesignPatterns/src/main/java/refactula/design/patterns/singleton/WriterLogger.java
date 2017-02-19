package refactula.design.patterns.singleton;

import java.io.PrintWriter;

/**
 * Example of a Logger implementation that cannot be a singleton.
 *
 * @see EmptyLogger EmptyLogger - a singleton Logger implementation
 */
public class WriterLogger implements Logger {

    private final PrintWriter writer;

    public WriterLogger(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void error(String message) {
        writer.println("Error: " + message);
        writer.flush();
    }

    @Override
    public void warn(String message) {
        writer.println("Warn: " + message);
        writer.flush();
    }

    @Override
    public void info(String message) {
        writer.println("Info: " + message);
        writer.flush();
    }

    @Override
    public void debug(String message) {
        writer.println("Debug: " + message);
        writer.flush();
    }

    @Override
    public void trace(String message) {
        writer.println("Trace: " + message);
        writer.flush();
    }

    @Override
    public void error(String message, Throwable throwable) {
        writer.println("Error: " + message);
        throwable.printStackTrace(writer);
        writer.flush();
    }

}
