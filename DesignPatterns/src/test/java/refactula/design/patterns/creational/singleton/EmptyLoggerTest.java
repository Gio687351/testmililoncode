package refactula.design.patterns.creational.singleton;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EmptyLoggerTest {

    @Test
    public void shouldBeAbleToAccessTheInstance() {
        assertNotNull(EmptyLogger.INSTANCE);
    }

    @Test
    public void shouldBeAbleToUseTheInstance() {
        log(EmptyLogger.INSTANCE);
    }

    private void log(Logger logger) {
        logger.trace("Trace message");
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.error("Error message with throwable", new RuntimeException("Fake exception"));
    }

}