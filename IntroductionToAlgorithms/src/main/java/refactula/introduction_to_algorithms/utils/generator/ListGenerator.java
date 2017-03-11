package refactula.introduction_to_algorithms.utils.generator;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListGenerator<T> extends RandomGenerator<List<T>> {
    private final Generator<T> elementGenerator;
    private final int minSizeInclusive;
    private final int maxSizeExclusive;

    public ListGenerator(Random random, Generator<T> elementGenerator, int minSizeInclusive, int maxSizeExclusive) {
        super(random);
        Preconditions.checkNotNull(elementGenerator);
        Preconditions.checkArgument(minSizeInclusive < maxSizeExclusive);
        this.elementGenerator = elementGenerator;
        this.minSizeInclusive = minSizeInclusive;
        this.maxSizeExclusive = maxSizeExclusive;
    }

    @Override
    public List<T> generate() {
        int size = minSizeInclusive + nextInt(maxSizeExclusive - minSizeInclusive);
        ArrayList<T> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(elementGenerator.generate());
        }
        return arrayList;
    }
}
