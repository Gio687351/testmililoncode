package refactula.design.patterns.creational.singleton;

/**
 * A general Logger interface.
 *
 * @see EmptyLogger EmptyLogger - a singleton implementation of this interface
 */
public interface Logger {
    void error(String message);
    void warn(String message);
    void info(String message);
    void debug(String message);
    void trace(String message);
    void error(String message, Throwable throwable);
}
