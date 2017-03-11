package refactula.introduction_to_algorithms.quicksort;

import refactula.introduction_to_algorithms.IntArraySortTest;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

public class QuicksortTest extends IntArraySortTest {

    @Override
    protected SortingAlgorithm<Integer> sortingAlgorithm() {
        return new Quicksort<>();
    }
}