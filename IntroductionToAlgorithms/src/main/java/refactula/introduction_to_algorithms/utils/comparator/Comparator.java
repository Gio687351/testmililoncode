package refactula.introduction_to_algorithms.utils.comparator;

import java.util.function.Function;

public interface Comparator<T> extends java.util.Comparator<T> {

    static <T extends Comparable<T>> Comparator<T> naturalOrder() {
        return java.util.Comparator.<T>naturalOrder()::compare;
    }

    default boolean is(T first, Comparison comparison, T second) {
        return comparison.matches(compare(first, second));
    }

    default <R> Comparator<R> by(Function<R, T> mapping) {
        return (a, b) -> compare(mapping.apply(a), mapping.apply(b));
    }

}
