package refactula.introduction_to_algorithms.counting_sort;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.enumeration.Enumeration;
import refactula.introduction_to_algorithms.utils.sorting.ArraySorting;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

public class CountingSort<T> implements SortingAlgorithm<T> {
    private final Enumeration<T> enumeration;

    public CountingSort(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public void sort(Array<T> array, Comparator<T> comparator) {
        Array<Integer> count = Arrays.ofInts(enumeration.valuesAmount());
        Array<T> buffer = Arrays.ofObjects(array.length());

        new ArraySorting<T>(array, comparator) {

            @Override
            public void sort() {
                for (int i = 0; i < length(); i++) {
                    int index = enumeration.getIndex(get(i));
                    count.set(index, count.get(index) + 1);
                }
                for (int i = 1; i < count.length(); i++) {
                    count.set(i, count.get(i - 1) + count.get(i));
                }
                for (int i = length() - 1; i >= 0; i--) {
                    T element = get(i);
                    int index = enumeration.getIndex(element);
                    int elementCount = count.get(index);
                    buffer.set(elementCount - 1, element);
                    count.set(index, elementCount - 1);
                }
                for (int i = 0; i < length(); i++) {
                    set(i, buffer.get(i));
                }
            }

        }.sort();
    }
}
