package refactula.design.patterns.behavioral.strategy;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;

public class Future<T> {
    private volatile AtomicReference<T> valueRef = new AtomicReference<>();
    private final Queue<Listener<T>> listenersQueue = new ConcurrentLinkedQueue<>();

    void complete(T value) {
        if (valueRef.compareAndSet(null, value)) {
            notifyListeners();
        }
    }

    public void subscribe(Listener<T> listener) {
        listenersQueue.add(listener);
        notifyListeners();
    }

    private void notifyListeners() {
        T value = valueRef.get();
        if (value != null) {
            Listener<T> listener = listenersQueue.poll();
            while (listener != null) {
                listener.onCompleted(value);
                listener = listenersQueue.poll();
            }
        }
    }

    static <T> Future<T> submit(ExecutorService service, Supplier<T> task) {
        Future<T> future = new Future<>();
        service.execute(() -> future.complete(task.get()));
        return future;
    }

    static <T> Future<T> ofValue(T value) {
        Future<T> future = new Future<>();
        future.complete(value);
        return future;
    }

    public <R> Future<R> flatMap(Function<T, Future<R>> function) {
        Future<R> future = new Future<>();
        subscribe(value -> function.apply(value).subscribe(future::complete));
        return future;
    }

    public interface Listener<T> {
        void onCompleted(T value);
    }
}
