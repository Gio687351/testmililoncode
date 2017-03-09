package refactula.design.patterns.behavioral.strategy;

import java.util.concurrent.TimeUnit;

public class SlowSerializer implements QueueSerializer {
    private final QueueSerializer delegate;
    private final int delay;
    private final TimeUnit units;

    public SlowSerializer(QueueSerializer delegate, int delay, TimeUnit units) {
        this.delegate = delegate;
        this.delay = delay;
        this.units = units;
    }

    @Override
    public String serialize(QueueMessage message) {
        try {
            Thread.sleep(units.toMillis(delay));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return delegate.serialize(message);
    }
}
