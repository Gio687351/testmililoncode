package refactula.introduction_to_algorithms.utils.generator;

import com.google.common.base.Preconditions;

import java.util.Random;

public final class IntegerGenerator extends RandomGenerator<Integer> {
    private final int minInclusive;
    private final int maxExclusive;

    public IntegerGenerator(Random random, int minInclusive, int maxExclusive) {
        super(random);
        Preconditions.checkArgument(minInclusive < maxExclusive);
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }

    @Override
    public Integer generate() {
        return minInclusive + nextInt(maxExclusive - minInclusive);
    }
}
