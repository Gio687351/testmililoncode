package refactula.design.patterns.singleton;

/**
 * A perfect usage of Singleton pattern:
 * <ul>
 * <li> uniqueness is guaranteed by enum constant guarantees
 * <li> the instance is a stateless interface implementation,
 *      which can be passed around to other classes expecting the interface
 * <li> there is no benefit of having multiple instances of this class - a single can be used everywhere
 * </ul>
 */
public enum EmptyLogger implements Logger {
    INSTANCE;

    @Override public void error(String s) { /* do nothing */ }
    @Override public void warn(String s) { /* do nothing */ }
    @Override public void info(String s) { /* do nothing */ }
    @Override public void debug(String s) { /* do nothing */ }
    @Override public void trace(String s) { /* do nothing */ }
    @Override public void error(String s, Throwable throwable) { /* do nothing */ }
}

