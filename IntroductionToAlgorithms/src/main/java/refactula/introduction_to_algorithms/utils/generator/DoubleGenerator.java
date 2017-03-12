package refactula.introduction_to_algorithms.utils.generator;

import com.google.common.base.Preconditions;

import java.util.Random;

public final class DoubleGenerator extends RandomGenerator<Double> {
    private final double minInclusive;
    private final double maxExclusive;

    public DoubleGenerator(Random random, double minInclusive, double maxExclusive) {
        super(random);
        Preconditions.checkArgument(minInclusive < maxExclusive);
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }

    @Override
    public Double generate() {
        return minInclusive + nextDouble() * (maxExclusive - minInclusive);
    }
}
