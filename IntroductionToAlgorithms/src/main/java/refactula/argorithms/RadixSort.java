package refactula.argorithms;

import java.util.Arrays;

public class RadixSort {

    public static void sort(int[] a) {
        int d = 1;
        boolean shouldStop;
        int[] b = new int[10];
        int[] c = new int[a.length];
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
            for (int i = c.length - 1; i >= 0; i--) {
                a[--b[(c[i] / d) % 10]] = c[i];
            }
            d *= 10;
        } while (!shouldStop);
    }

}
