package refactula.micro.futuristic.utils;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface Future<T> {

    <R> Future<R> map(Function<T, R> function);

    <R> Future<R> flatMap(Function<T, Future<R>> function);

    <R, S> Future<S> map2(Future<R> otherFuture, BiFunction<T, R, S> joiner);

}
