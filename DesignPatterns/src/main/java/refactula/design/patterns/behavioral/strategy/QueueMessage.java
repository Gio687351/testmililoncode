package refactula.design.patterns.behavioral.strategy;

import java.io.Serializable;

public class QueueMessage implements Serializable {
    private final String text;

    public QueueMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
