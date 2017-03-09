package refactula.design.patterns.behavioral.strategy;

public enum QueueTextSerializer implements QueueSerializer {
    INSTANCE;

    @Override
    public String serialize(QueueMessage message) {
        return message.getText();
    }
}
