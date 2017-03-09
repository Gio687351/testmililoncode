package refactula.design.patterns.behavioral.strategy;

public enum  SimpleQueueSerializerStrategy implements QueueSerializerStrategy {
    INSTANCE;

    @Override
    public Future<String> serialize(QueueSerializer serializer, QueueMessage message) {
        return Future.ofValue(serializer.serialize(message));
    }
}
