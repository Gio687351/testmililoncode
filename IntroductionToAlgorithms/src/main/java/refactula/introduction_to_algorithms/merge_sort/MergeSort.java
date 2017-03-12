package refactula.introduction_to_algorithms.merge_sort;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.sorting.ArraySorting;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

import static refactula.introduction_to_algorithms.utils.comparator.Comparison.LESS_THAN_OR_EQUAL_TO;

public class MergeSort<T> implements SortingAlgorithm<T> {
    @Override
    public void sort(Array<T> array, Comparator<T> comparator) {
        Array<T> buffer = Arrays.ofObjects(array.length());
        new ArraySorting<T>(array, comparator) {

            @Override
            public void sort() {
                sort(0, length() - 1);
            }

            private void sort(int l, int r) {
                if (l >= r) {
                    return;
                }
                int m = (l + r) / 2;
                sort(l, m);
                sort(m + 1, r);
                merge(l, m, r);
            }

            private void merge(int l, int m, int r) {
                int n = r - l + 1;
                int i1 = l;
                int i2 = m + 1;
                int j = 0;
                while (j < n) {
                    if (i2 > r || i1 <= m && is(get(i1), LESS_THAN_OR_EQUAL_TO, get(i2))) {
                        buffer.set(j++, get(i1++));
                    } else {
                        buffer.set(j++, get(i2++));
                    }
                }
                for (int i = 0; i < n; i++) {
                    set(l + i, buffer.get(i));
                }
            }

        }.sort();
    }
}
