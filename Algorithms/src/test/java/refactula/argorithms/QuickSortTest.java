package refactula.argorithms;

import refactula.argorithms.sorting.QuickSort;
import refactula.argorithms.sorting.SortingAlgorithm;

public class QuickSortTest extends AbstractSortTest {

    @Override
    protected SortingAlgorithm getAlgorithm() {
        return QuickSort.ALGORITHM;
    }

}