package refactula.micro.futuristic.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class NetworkClient {
    private final int minDelay;
    private final int maxDelay;

    public NetworkClient(int minDelay, int maxDelay) {
        this.minDelay = minDelay;
        this.maxDelay = maxDelay;
    }

    protected final void overNetwork(Runnable runnable) {
        overNetwork(() -> {
            runnable.run();
            return null;
        });
    }

    protected final <T> T overNetwork(Supplier<T> operation) {
        networkLag();
        return operation.get();
    }

    private void networkLag() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomDelay = random.nextInt(minDelay, maxDelay);
        System.out.println("Network lag: " + randomDelay + " ms...");
        sleep(randomDelay);
    }

    private void sleep(int randomDelay) {
        try {
            Thread.sleep(randomDelay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
