package refactula.argorithms;

public class HeapSort {

    public static final SortingAlgorithm ALGORITHM = HeapSort::sort;

    public static void sort(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i, a.length);
        }
        for (int heapSize = a.length - 1; heapSize >= 0; heapSize--) {
            exchange(a, 0, heapSize);
            heapify(a, 0, heapSize);
        }
    }

    private static void heapify(int[] a, int i, int heapSize) {
        int l = 2 * i + 1;
        int r = l + 1;
        int max;
        if (l < heapSize && a[l] > a[i]) {
            max = l;
        } else {
            max = i;
        }
        if (r < heapSize && a[r] > a[max]) {
            max = r;
        }
        if (max != i) {
            exchange(a, i, max);
            heapify(a, max, heapSize);
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

}
