package refactula.introduction_to_algorithms.utils.sorting;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;

public interface SortingAlgorithm<T> {

    void sort(Array<T> array, Comparator<T> comparator);

}
