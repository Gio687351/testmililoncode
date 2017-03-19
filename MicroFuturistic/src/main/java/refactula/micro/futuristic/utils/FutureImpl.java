package refactula.micro.futuristic.utils;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FutureImpl<T> implements Future<T> {
    private final AtomicReference<Optional<T>> result = new AtomicReference<>();
    private final Queue<Consumer<T>> listeners = new ConcurrentLinkedQueue<>();

    @Override
    public <R> Future<R> map(Function<T, R> function) {
        FutureImpl<R> future = new FutureImpl<>();
        subscribe(value -> future.commit(function.apply(value)));
        return future;
    }

    @Override
    public <R, S> Future<S> map2(Future<R> otherFuture, BiFunction<T, R, S> joiner) {
        return flatMap(firstResult ->
                otherFuture.map(secondResult ->
                joiner.apply(firstResult, secondResult)));
    }

    @Override
    public <R> Future<R> flatMap(Function<T, Future<R>> function) {
        FutureImpl<R> future = new FutureImpl<>();
        subscribe(value ->
            function.apply(value).map(x -> {
                future.commit(x);
                return null;
            })
        );
        return future;
    }

    public void commit(T value) {
        if (result.compareAndSet(null, Optional.ofNullable(value))) {
            notify(value);
        }
    }

    public void subscribe(Consumer<T> listener) {
        Optional<T> value = result.get();
        if (value != null) {
            listener.accept(value.orElse(null));
            return;
        }
        listeners.add(listener);
        value = result.get();
        if (value != null) {
            notify(value.orElse(null));
        }
    }

    private void notify(T value) {
        Consumer<T> listener;
        while ((listener = listeners.poll()) != null) {
            listener.accept(value);
        }
    }
}
