package refactula.argorithms;

public class InsertionSort {

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int c = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > c) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = c;
        }
    }

}
