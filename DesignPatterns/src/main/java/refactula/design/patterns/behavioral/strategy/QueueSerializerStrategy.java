package refactula.design.patterns.behavioral.strategy;

public interface QueueSerializerStrategy {

    Future<String> serialize(QueueSerializer serializer, QueueMessage message);

}
