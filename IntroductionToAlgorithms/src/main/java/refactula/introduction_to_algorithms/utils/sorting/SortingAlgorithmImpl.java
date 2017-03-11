package refactula.introduction_to_algorithms.utils.sorting;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;

public class SortingAlgorithmImpl<T> implements SortingAlgorithm<T> {
    private final SortFactory<T> sortFactory;

    public SortingAlgorithmImpl(SortFactory<T> sortFactory) {
        this.sortFactory = sortFactory;
    }

    @Override
    public void sort(Array<T> array, Comparator<T> comparator) {
        sortFactory.create(array, comparator).sort();
    }

    public interface SortFactory<T> {
        ArraySorting<T> create(Array<T> array, Comparator<T> comparator);
    }
}
