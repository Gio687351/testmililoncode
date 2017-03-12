package refactula.introduction_to_algorithms.counting_sort;

import refactula.introduction_to_algorithms.IntArraySortTest;
import refactula.introduction_to_algorithms.utils.enumeration.IntegerRange;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

public class CountingSortTest extends IntArraySortTest {

    @Override
    protected SortingAlgorithm<Integer> sortingAlgorithm() {
        return new CountingSort<>(new IntegerRange(minElement(), maxElement()));
    }

    @Override
    protected int samplesAmount() {
        return 1000;
    }

    @Override
    protected int maxArraySize() {
        return 10000;
    }

    @Override
    protected int maxElement() {
        return 50;
    }

    @Override
    protected int minElement() {
        return -50;
    }
}