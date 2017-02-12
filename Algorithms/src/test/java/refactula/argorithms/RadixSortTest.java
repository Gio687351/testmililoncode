package refactula.argorithms;

import org.junit.Before;

public class RadixSortTest extends AbstractSortTest {

    private RadixSort radixSort;

    @Before
    public void setUp() {
        radixSort = new RadixSort();
    }

    @Override
    protected void sort(int[] a) {
        radixSort.sort(a);
    }

}