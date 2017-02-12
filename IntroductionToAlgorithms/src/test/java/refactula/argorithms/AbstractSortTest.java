package refactula.argorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public abstract class AbstractSortTest {

    protected abstract void sort(int[] a);

    protected void test(int... a) {
        int[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        sort(a);
        Assert.assertArrayEquals(copy, a);
    }

    @Test
    public void testSorted() {
        test(1, 2, 3, 4, 5);
    }

    @Test
    public void testSorted2() {
        test(5, 4, 3, 2, 1);
    }

    @Test
    public void testSorted3() {
        test(5, 2, 3, 4, 1);
    }

    @Test
    public void testSorted5() {
        test(1, 0, -1);
    }

    @Test
    public void testRandom() {
        Random r = new Random(7515353);
        for (int i = 0; i < 10000; i++) {
            int n = r.nextInt(20);
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = r.nextInt(100) - 50;
            }
            test(a);
        }
    }

}
