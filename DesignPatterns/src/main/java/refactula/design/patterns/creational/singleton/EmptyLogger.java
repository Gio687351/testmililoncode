package refactula.design.patterns.creational.singleton;

/**
 * Logger implementation that does nothing.
 *
 * <p>A perfect Singleton example:
 * <ul>
 * <li> uniqueness is guaranteed by enum constant guarantees
 * <li> the instance is a stateless interface implementation,
 *      which can be passed around to other classes expecting the interface
 * <li> there is no benefit of having multiple instances of this class - a single can be used everywhere
 * </ul>
 */
public enum EmptyLogger implements Logger {
    INSTANCE;

    @Override public void error(String message) { /* do nothing */ }
    @Override public void warn(String message) { /* do nothing */ }
    @Override public void info(String message) { /* do nothing */ }
    @Override public void debug(String message) { /* do nothing */ }
    @Override public void trace(String message) { /* do nothing */ }
    @Override public void error(String message, Throwable throwable) { /* do nothing */ }
}

