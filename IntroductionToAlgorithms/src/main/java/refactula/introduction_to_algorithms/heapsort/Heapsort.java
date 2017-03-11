package refactula.introduction_to_algorithms.heapsort;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.sorting.ArraySorting;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

import static refactula.introduction_to_algorithms.utils.comparator.Comparison.GREATER_THAN;

public class Heapsort<T> implements SortingAlgorithm<T> {

    @Override
    public void sort(Array<T> array, Comparator<T> comparator) {
        new ArraySorting<T>(array, comparator) {

            @Override
            public void sort() {
                for (int i = length() / 2; i >= 0; i--) {
                    heapify(i, length());
                }
                for (int i = length() - 1; i >= 0; i--) {
                    swap(0, i);
                    heapify(0, i);
                }
            }

            private void heapify(int i, int heapsize) {
                int l = i * 2 + 1;
                int r = l + 1;
                int max = i;
                if (l < heapsize && is(get(l), GREATER_THAN, get(i))) {
                    max = l;
                }
                if (r < heapsize && is(get(r), GREATER_THAN, get(max))) {
                    max = r;
                }
                if (i != max) {
                    swap(i, max);
                    heapify(max, heapsize);
                }
            }

        }.sort();
    }

}
