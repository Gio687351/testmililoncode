package refactula.argorithms;

import java.util.Arrays;

public class RadixSort implements SortingAlgorithm {

    private final int[] b = new int[10];
    private int[] c = new int[16];

    @Override
    public void sort(int[] a) {
        ensureCapacity(a.length);
        int d = 1;
        boolean shouldStop;
        do {
            Arrays.fill(b, 0);
            shouldStop = true;
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i];
                shouldStop = shouldStop && a[i] < d;
                b[(a[i] / d) % 10]++;
            }
            for (int i = 1; i < b.length; i++) {
                b[i] += b[i - 1];
            }
            for (int i = a.length - 1; i >= 0; i--) {
                a[--b[(c[i] / d) % 10]] = c[i];
            }
            d *= 10;
        } while (!shouldStop);
    }

    private void ensureCapacity(int length) {
        if (c.length < length) {
            c = new int[Math.max(c.length * 2, length)];
        }
    }

}
