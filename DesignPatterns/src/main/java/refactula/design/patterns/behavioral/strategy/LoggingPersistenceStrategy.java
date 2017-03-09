package refactula.design.patterns.behavioral.strategy;

public class LoggingPersistenceStrategy implements QueuePersistenceStrategy {
    @Override
    public Future<Void> persist(String message) {
        System.out.println(message);
        return Future.ofValue(null);
    }
}
