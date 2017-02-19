package refactula.design.patterns.singleton;

/**
 * @see EmptyLogger EmptyLogger - a singleton implementation of this interface
 */
public interface Logger {
    void error(String s);
    void warn(String s);
    void info(String s);
    void debug(String s);
    void trace(String s);
    void error(String s, Throwable throwable);
}
