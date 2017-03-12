package refactula.introduction_to_algorithms.radix_sort;

import refactula.introduction_to_algorithms.counting_sort.CountingSort;
import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.enumeration.Enumeration;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

final class DigitSort implements SortingAlgorithm<Integer>, Enumeration<Integer> {
    private final DigitEnumeration digitEnumeration;
    private final CountingSort<Integer> digitSort;

    DigitSort(DigitEnumeration digitEnumeration, CountingSort<Integer> digitSort) {
        this.digitEnumeration = digitEnumeration;
        this.digitSort = digitSort;
    }

    @Override
    public int valuesAmount() {
        return digitEnumeration.valuesAmount();
    }

    @Override
    public int getIndex(Integer value) {
        return digitEnumeration.getIndex(value);
    }

    @Override
    public void sort(Array<Integer> array, Comparator<Integer> comparator) {
        digitSort.sort(array, comparator);
    }
}
