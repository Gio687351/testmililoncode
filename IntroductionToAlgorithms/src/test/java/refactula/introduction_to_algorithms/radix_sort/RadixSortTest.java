package refactula.introduction_to_algorithms.radix_sort;

import refactula.introduction_to_algorithms.IntArraySortTest;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

public class RadixSortTest extends IntArraySortTest {

    @Override
    protected SortingAlgorithm<Integer> sortingAlgorithm() {
        return RadixSortFactory.create();
    }

}