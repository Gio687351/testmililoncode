package refactula.introduction_to_algorithms;

import org.junit.ComparisonFailure;
import org.junit.Test;
import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.generator.Generator;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static refactula.introduction_to_algorithms.utils.comparator.Comparison.EQUAL_TO;

public abstract class SortingTest<T> {

    protected int samplesAmount() {
        return 10000;
    }

    protected abstract SortingAlgorithm<T> sortingAlgorithm();

    protected abstract Generator<Array<T>> arrayGenerator();

    protected abstract Comparator<T> comparator();

    @Test
    public void test() {
        SortingAlgorithm<T> algorithm = sortingAlgorithm();
        Generator<Array<T>> arrayGenerator = arrayGenerator();
        Comparator<T> comparator = comparator();
        for (int sample = samplesAmount(); sample > 0; sample--) {
            Array<T> array = arrayGenerator.generate();
            Array<T> sortedCopy = Arrays.ofList(Arrays.asList(array)
                    .stream()
                    .sorted(comparator)
                    .collect(Collectors.toList()));
            algorithm.sort(array, comparator);
            assertComparablyEquals(sortedCopy, array, comparator);
        }
    }

    private void assertComparablyEquals(Array<T> expected, Array<T> actual, Comparator<T> comparator) {
        assertEquals(expected.length(), actual.length());
        for (int i = 0; i < expected.length(); i++) {
            if (!comparator.is(expected.get(i), EQUAL_TO, actual.get(i))) {
                throw new ComparisonFailure("Arrays are not comparably equal", expected.toString(), actual.toString());
            }
        }
    }

}
