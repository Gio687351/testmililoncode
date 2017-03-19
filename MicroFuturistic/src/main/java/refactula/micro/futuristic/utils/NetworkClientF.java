package refactula.micro.futuristic.utils;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class NetworkClientF {
    private final ScheduledExecutorService executorService;
    private final int minDelay;
    private final int maxDelay;
    private final Logger logger;

    public NetworkClientF(ScheduledExecutorService executorService, int minDelay, int maxDelay, Logger logger) {
        this.executorService = executorService;
        this.minDelay = minDelay;
        this.maxDelay = maxDelay;
        this.logger = logger;
    }

    protected final <T> Future<T> perform(Supplier<Future<T>> supplier) {
        FutureImpl<T> future = new FutureImpl<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomDelay = random.nextInt(minDelay, maxDelay);
        logger.println("Network lag: " + randomDelay + " ms...");
        executorService.schedule(() -> supplier.get().map(value -> {
            future.commit(value);
            return null;
        }), randomDelay, TimeUnit.MILLISECONDS);
        return future;
    }
}
