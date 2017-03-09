package refactula.design.patterns.behavioral.observer;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Subscriptions<T> {

    private final Set<T> observers = new HashSet<>();

    public void subscribe(T observer) {
        observers.add(observer);
    }

    public void unsubscribe(T observer) {
        observers.remove(observer);
    }

    public void notify(Consumer<T> consumer) {
        observers.forEach(consumer);
    }

}
