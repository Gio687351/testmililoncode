package refactula.argorithms;

import refactula.argorithms.sorting.InsertionSort;

public class InsertionSortTest extends AbstractSortTest {

    @Override
    protected void sort(int[] a) {
        InsertionSort.sort(a);
    }

}