package refactula.argorithms.sorting;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static final SortingAlgorithm ALGORITHM = QuickSort::sort;

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = randomPartition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }

    private static int randomPartition(int[] a, int p, int r) {
        int i = ThreadLocalRandom.current().nextInt(p, r + 1);
        exchange(a, i, r);
        return partition(a, p, r);
    }

    private static void exchange(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int j = p - 1;
        for (int i = p; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                exchange(a, i, j);
            }
        }
        return j;
    }

}
