package refactula.introduction_to_algorithms.utils.generator;

import com.google.common.base.Preconditions;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public abstract class RandomGenerator<T> implements Generator<T> {
    private final Random random;

    public RandomGenerator(Random random) {
        this.random = Preconditions.checkNotNull(random);
    }

    protected final void nextBytes(byte[] bytes) {
        random.nextBytes(bytes);
    }

    protected final int nextInt() {
        return random.nextInt();
    }

    protected final int nextInt(int bound) {
        return random.nextInt(bound);
    }

    protected final long nextLong() {
        return random.nextLong();
    }

    protected final boolean nextBoolean() {
        return random.nextBoolean();
    }

    protected final float nextFloat() {
        return random.nextFloat();
    }

    protected final double nextDouble() {
        return random.nextDouble();
    }

    protected final double nextGaussian() {
        return random.nextGaussian();
    }

    protected final IntStream ints(long streamSize) {
        return random.ints(streamSize);
    }

    protected final IntStream ints() {
        return random.ints();
    }

    protected final IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        return random.ints(streamSize, randomNumberOrigin, randomNumberBound);
    }

    protected final IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        return random.ints(randomNumberOrigin, randomNumberBound);
    }

    protected final LongStream longs(long streamSize) {
        return random.longs(streamSize);
    }

    protected final LongStream longs() {
        return random.longs();
    }

    protected final LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        return random.longs(streamSize, randomNumberOrigin, randomNumberBound);
    }

    protected final LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        return random.longs(randomNumberOrigin, randomNumberBound);
    }

    protected final DoubleStream doubles(long streamSize) {
        return random.doubles(streamSize);
    }

    protected final DoubleStream doubles() {
        return random.doubles();
    }

    protected final DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        return random.doubles(streamSize, randomNumberOrigin, randomNumberBound);
    }

    protected final DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        return random.doubles(randomNumberOrigin, randomNumberBound);
    }
}
