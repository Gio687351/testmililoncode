package refactula.design.patterns.behavioral.strategy;

public interface QueuePersistenceStrategy {

    Future<Void> persist(String message);

}
