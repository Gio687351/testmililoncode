package refactula.introduction_to_algorithms.utils.generator;

import java.util.function.Function;

public interface Generator<T> {

    T generate();

    default <R> Generator<R> map(Function<T, R> function) {
        return () -> function.apply(generate());
    }

}
