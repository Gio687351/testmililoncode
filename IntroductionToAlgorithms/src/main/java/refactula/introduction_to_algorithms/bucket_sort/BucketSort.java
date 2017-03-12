package refactula.introduction_to_algorithms.bucket_sort;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.sorting.ArraySorting;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

import static refactula.introduction_to_algorithms.utils.comparator.Comparison.LESS_THAN;

public class BucketSort implements SortingAlgorithm<Double> {
    private final double rangeMin;
    private final double rangeMax;

    public BucketSort(double rangeMin, double rangeMax) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
    }

    @Override
    public void sort(Array<Double> array, Comparator<Double> comparator) {
        Array<Node> buckets = Arrays.ofObjects(array.length());
        for (int i = 0; i < buckets.length(); i++) {
            buckets.set(i, new Node(0, null));
        }

        new ArraySorting<Double>(array, comparator) {

            @Override
            public void sort() {
                for (int i = 0; i < length(); i++) {
                    double element = get(i);
                    int index = index(element);
                    Node before = buckets.get(index);
                    while (before.next != null && is(before.next.value, LESS_THAN, element)) {
                        before = before.next;
                    }
                    before.next = new Node(element, before.next);
                }
                for (int i = 0, j = 0; i < length(); i++) {
                    for (Node before = buckets.get(i); before.next != null; before = before.next) {
                        set(j++, before.next.value);
                    }
                }
            }

            int index(double value) {
                return (int) Math.floor((value - rangeMin) * length() / (rangeMax - rangeMin));
            }

        }.sort();
    }

    private static final class Node {
        private final double value;
        private Node next;

        private Node(double value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
