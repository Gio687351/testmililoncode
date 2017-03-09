package refactula.design.patterns.behavioral.strategy;

public class QueueClient {
    private final QueueSerializer serializer;
    private final QueueSerializerStrategy serializerStrategy;
    private final QueuePersistenceStrategy persistenceStrategy;

    public QueueClient(QueueSerializer serializer,
                       QueueSerializerStrategy serializerStrategy,
                       QueuePersistenceStrategy persistenceStrategy) {

        this.serializer = serializer;
        this.serializerStrategy = serializerStrategy;
        this.persistenceStrategy = persistenceStrategy;
    }

    public Future<Void> push(QueueMessage message) {
        return serializerStrategy.serialize(serializer, message).flatMap(persistenceStrategy::persist);
    }

}
