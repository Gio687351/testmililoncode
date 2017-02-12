package refactula.argorithms;

import refactula.argorithms.sorting.QuickSort;

public class QuickSortTest extends AbstractSortTest {

    @Override
    protected void sort(int[] a) {
        QuickSort.sort(a);
    }

}