package refactula.argorithms;

import refactula.argorithms.sorting.InsertionSort;
import refactula.argorithms.sorting.SortingAlgorithm;

public class InsertionSortTest extends AbstractSortTest {

    @Override
    protected SortingAlgorithm getAlgorithm() {
        return InsertionSort.ALGORITHM;
    }

}