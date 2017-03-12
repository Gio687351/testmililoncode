package refactula.introduction_to_algorithms.radix_sort;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

import java.util.List;

public final class RadixSort implements SortingAlgorithm<Integer> {
    private final List<DigitSort> digitSorts;

    RadixSort(List<DigitSort> digitSorts) {
        this.digitSorts = digitSorts;
    }

    @Override
    public void sort(Array<Integer> array, Comparator<Integer> comparator) {
        for (DigitSort sort : digitSorts) {
            sort.sort(array, comparator.by(sort::getIndex));
        }
    }
}
