package refactula.introduction_to_algorithms.heapsort;

import refactula.introduction_to_algorithms.IntArraySortTest;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

public class HeapsortTest extends IntArraySortTest {

    @Override
    protected SortingAlgorithm<Integer> sortingAlgorithm() {
        return new Heapsort<>();
    }

}