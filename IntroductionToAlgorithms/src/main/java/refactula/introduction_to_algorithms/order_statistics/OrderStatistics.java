package refactula.introduction_to_algorithms.order_statistics;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;

import java.util.concurrent.ThreadLocalRandom;

import static refactula.introduction_to_algorithms.utils.comparator.Comparison.LESS_THAN_OR_EQUAL_TO;

public class OrderStatistics {

    public static <T> T get(Array<T> a, Comparator<T> c, int k) {
        return get(a, c, k, 0, a.length() - 1);
    }

    private static <T> T get(Array<T> a, Comparator<T> c, int k, int l, int r) {
        int m = randomPartition(a, c, l, r);
        if (m == k) {
            return a.get(m);
        } else if (k < m) {
            return get(a, c, k, l, m - 1);
        } else {
            return get(a, c, k, m + 1, r);
        }
    }

    private static <T> int randomPartition(Array<T> a, Comparator<T> c, int l, int r) {
        int i = ThreadLocalRandom.current().nextInt(l, r + 1);
        a.swap(i, r);
        return partition(a, c, l, r);
    }

    private static <T> int partition(Array<T> a, Comparator<T> c, int l, int r) {
        int j = l;
        for (int i = l; i <= r; i++) {
            if (c.is(a.get(i), LESS_THAN_OR_EQUAL_TO, a.get(r))) {
                a.swap(j, i);
                j++;
            }
        }
        return j - 1;
    }

}
