package refactula.introduction_to_algorithms.utils.sorting;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.comparator.Comparator.PartialComparison;
import refactula.introduction_to_algorithms.utils.comparator.Comparison;

public abstract class ArraySorting<T> {
    private final Array<T> array;
    private final Comparator<T> comparator;

    public ArraySorting(Array<T> array, Comparator<T> comparator) {
        this.array = array;
        this.comparator = comparator;
    }

    public abstract void sort();

    protected final int length() {
        return array.length();
    }

    protected final T get(int index) {
        return array.get(index);
    }

    protected final void set(int index, T value) {
        array.set(index, value);
    }

    protected final boolean is(T first, Comparison comparison, T second) {
        return comparator.is(first, comparison, second);
    }

    protected final PartialComparison<T> is(T first) {
        return comparator.is(first);
    }
}
