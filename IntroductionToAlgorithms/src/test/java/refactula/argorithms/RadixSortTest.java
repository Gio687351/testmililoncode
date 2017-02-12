package refactula.argorithms;

import org.junit.Assert;
import org.junit.Test;

public class RadixSortTest extends AbstractSortTest {

    @Override
    protected void sort(int[] a) {
        RadixSort.sort(a);
    }

    @Test
    public void testRadixSort() {
        int[] a = {1, 1, 0, 5, 3};
        sort(a);
        Assert.assertArrayEquals(new int[] {0, 1, 1, 3, 5}, a);
    }

}