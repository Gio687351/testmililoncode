package refactula.design.patterns.behavioral.strategy;

import java.util.concurrent.ExecutorService;

public class MultithreadedQueueSerializerStrategy implements QueueSerializerStrategy {
    private final ExecutorService executorService;

    public MultithreadedQueueSerializerStrategy(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public Future<String> serialize(QueueSerializer serializer, QueueMessage message) {
        return Future.submit(executorService, () -> serializer.serialize(message));
    }
}
