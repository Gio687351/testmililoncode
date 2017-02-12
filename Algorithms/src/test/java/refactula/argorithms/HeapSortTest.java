package refactula.argorithms;

import refactula.argorithms.sorting.HeapSort;

public class HeapSortTest extends AbstractSortTest {

    @Override
    protected void sort(int[] a) {
        HeapSort.sort(a);
    }

}