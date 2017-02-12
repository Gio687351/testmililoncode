package refactula.argorithms;

import refactula.argorithms.sorting.RadixSort;
import refactula.argorithms.sorting.SortingAlgorithm;

public class RadixSortTest extends AbstractSortTest {

    @Override
    protected SortingAlgorithm getAlgorithm() {
        return new RadixSort();
    }

}