package refactula.introduction_to_algorithms.quicksort;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.sorting.ArraySorting;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

import java.util.concurrent.ThreadLocalRandom;

import static refactula.introduction_to_algorithms.utils.comparator.Comparison.SMALLER_THAN_OR_EQUAL_TO;

public class Quicksort<T> implements SortingAlgorithm<T> {
    @Override
    public void sort(Array<T> array, Comparator<T> comparator) {
        new ArraySorting<T>(array, comparator) {

            @Override
            public void sort() {
                sort(0, length() - 1);
            }

            private void sort(int l, int r) {
                if (l >= r) {
                    return;
                }
                int m = randomPartition(l, r);
                sort(l, m - 1);
                sort(m + 1, r);
            }

            private int randomPartition(int l, int r) {
                int m = ThreadLocalRandom.current().nextInt(l, r + 1);
                swap(m, r);
                return partition(l, r);
            }

            private int partition(int l, int r) {
                int j = l;
                for (int i = l; i <= r; i++) {
                    if (is(get(i), SMALLER_THAN_OR_EQUAL_TO, get(r))) {
                        swap(j, i);
                        j++;
                    }
                }
                return j - 1;
            }

        }.sort();
    }
}
