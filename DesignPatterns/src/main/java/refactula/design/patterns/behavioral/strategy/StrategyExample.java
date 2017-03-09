package refactula.design.patterns.behavioral.strategy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StrategyExample {
    private final QueueClient queueClient;

    public StrategyExample(QueueClient queueClient) {
        this.queueClient = queueClient;
    }

    public void run() {
        queueClient.push(new QueueMessage("Message1"));
        queueClient.push(new QueueMessage("Message2"));
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        QueueClient queueClient = new QueueClient(

                // QueueTextSerializer.INSTANCE,
                // ByteQueueSerializer.INSTANCE,
                new SlowSerializer(QueueTextSerializer.INSTANCE, 3, TimeUnit.SECONDS),

                // SimpleQueueSerializerStrategy.INSTANCE,
                new MultithreadedQueueSerializerStrategy(executorService),

                new LoggingPersistenceStrategy()

        );

        new StrategyExample(queueClient).run();
        executorService.shutdown();
    }
}
