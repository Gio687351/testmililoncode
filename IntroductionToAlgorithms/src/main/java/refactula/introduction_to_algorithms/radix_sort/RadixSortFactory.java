package refactula.introduction_to_algorithms.radix_sort;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import refactula.introduction_to_algorithms.counting_sort.CountingSort;

import java.util.List;

public final class RadixSortFactory {
    private RadixSortFactory() {
        // private constructor
    }

    public static RadixSort create() {
        return create(10, Integer.MAX_VALUE);
    }

    public static RadixSort create(int exp, int maxValue) {
        Preconditions.checkArgument(exp > 1);
        Preconditions.checkArgument(maxValue > 0);
        return new RadixSort(createSorts(exp, maxValue));
    }

    private static List<DigitSort> createSorts(int exp, int maxValue) {
        Builder<DigitSort> builder = ImmutableList.builder();
        long pow = 1;
        while (pow * exp < maxValue) {
            DigitEnumeration digitEnumeration = new DigitEnumeration((int) pow, exp);
            builder.add(new DigitSort(digitEnumeration, new CountingSort<>(digitEnumeration)));
            pow *= exp;
        }
        return builder.build();
    }
}
