package refactula.introduction_to_algorithms.utils.enumeration;

import com.google.common.base.Preconditions;

public class IntRangeEnumeration implements Enumeration<Integer> {
    private final int minInclusive;
    private final int maxExclusive;

    public IntRangeEnumeration(int minInclusive, int maxExclusive) {
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }

    @Override
    public int valuesAmount() {
        return maxExclusive - minInclusive;
    }

    @Override
    public int getIndex(Integer value) {
        Preconditions.checkArgument(contains(value),
                "Value %s is outsize of the range [%s, %s)", value, minInclusive, maxExclusive);
        return value - minInclusive;
    }

    public boolean contains(Integer value) {
        return minInclusive <= value && value < maxExclusive;
    }
}
