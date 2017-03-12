package refactula.introduction_to_algorithms.counting_sort;

import refactula.introduction_to_algorithms.IntArraySortTest;
import refactula.introduction_to_algorithms.utils.enumeration.IntRangeEnumeration;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

public class CountingSortTest extends IntArraySortTest {

    @Override
    protected SortingAlgorithm<Integer> sortingAlgorithm() {
        return new CountingSort<>(new IntRangeEnumeration(minElement(), maxElement()));
    }

    @Override
    protected int samplesAmount() {
        return 1000;
    }

    @Override
    protected int maxArraySize() {
        return 1000;
    }

    @Override
    protected int maxElement() {
        return 10;
    }

    @Override
    protected int minElement() {
        return -10;
    }
}