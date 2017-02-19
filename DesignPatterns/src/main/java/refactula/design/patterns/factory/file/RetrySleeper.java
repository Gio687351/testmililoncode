package refactula.design.patterns.factory.file;

public class RetrySleeper {
    private final long delay;
    private final RuntimeExceptionFactory exceptionFactory;

    public RetrySleeper(long delay, RuntimeExceptionFactory exceptionFactory) {
        this.delay = delay;
        this.exceptionFactory = exceptionFactory;
    }

    public void sleep() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw exceptionFactory.throwBecause("Interrupted", e);
        }
    }
}