package refactula.micro.futuristic.utils;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class NetworkAdapterF {
    private final ScheduledExecutorService executorService;
    private final int minDelay;
    private final int maxDelay;
    private final Logger logger;

    public NetworkAdapterF(ScheduledExecutorService executorService, int minDelay, int maxDelay, Logger logger) {
        this.executorService = executorService;
        this.minDelay = minDelay;
        this.maxDelay = maxDelay;
        this.logger = logger;
    }

    protected final <T> Future<T> perform(Supplier<T> supplier) {
        FutureImpl<T> future = new FutureImpl<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomDelay = random.nextInt(minDelay, maxDelay);
        logger.println("Network lag: " + randomDelay + " ms...");
        executorService.schedule(() -> future.commit(supplier.get()), randomDelay, TimeUnit.MILLISECONDS);
        return future;
    }

    protected final Future<Void> perform(Runnable runnable) {
        return perform(() -> {
            runnable.run();
            return null;
        });
    }
}
