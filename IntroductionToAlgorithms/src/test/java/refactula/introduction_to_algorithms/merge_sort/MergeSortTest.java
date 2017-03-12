package refactula.introduction_to_algorithms.merge_sort;

import refactula.introduction_to_algorithms.IntArraySortTest;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

public class MergeSortTest extends IntArraySortTest {

    @Override
    protected SortingAlgorithm<Integer> sortingAlgorithm() {
        return new MergeSort<>();
    }

}