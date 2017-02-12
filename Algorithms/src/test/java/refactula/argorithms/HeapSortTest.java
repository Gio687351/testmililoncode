package refactula.argorithms;

import refactula.argorithms.sorting.HeapSort;
import refactula.argorithms.sorting.SortingAlgorithm;

public class HeapSortTest extends AbstractSortTest {

    @Override
    protected SortingAlgorithm getAlgorithm() {
        return HeapSort.ALGORITHM;
    }

}