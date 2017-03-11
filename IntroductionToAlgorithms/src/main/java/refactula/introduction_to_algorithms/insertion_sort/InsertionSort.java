package refactula.introduction_to_algorithms.insertion_sort;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.sorting.ArraySorting;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

public class InsertionSort<T> implements SortingAlgorithm<T> {

    @Override
    public void sort(Array<T> array, Comparator<T> comparator) {
        new ArraySorting<T>(array, comparator) {
            @Override
            public void sort() {
                for (int i = 1; i < length(); i++) {
                    T k = get(i);
                    int j = i;
                    while (j > 0 && is(get(j - 1)).greaterThan(get(j))) {
                        set(j, get(j - 1));
                        j--;
                    }
                    set(i, k);
                }
            }
        }.sort();
    }

}
