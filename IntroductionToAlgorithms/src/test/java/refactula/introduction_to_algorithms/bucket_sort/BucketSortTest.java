package refactula.introduction_to_algorithms.bucket_sort;

import refactula.introduction_to_algorithms.SortingTest;
import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.generator.DoubleGenerator;
import refactula.introduction_to_algorithms.utils.generator.Generator;
import refactula.introduction_to_algorithms.utils.generator.ListGenerator;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

import java.util.Random;

public class BucketSortTest extends SortingTest<Double> {
    private static final double RANGE_MIN = 0d;
    private static final double RANGE_MAX = 1d;

    @Override
    protected SortingAlgorithm<Double> sortingAlgorithm() {
        return new BucketSort(RANGE_MIN, RANGE_MAX);
    }

    @Override
    protected Generator<Array<Double>> arrayGenerator() {
        Random random = new Random(753951);
        DoubleGenerator elementGenerator = new DoubleGenerator(random, RANGE_MIN, RANGE_MAX);
        ListGenerator<Double> listGenerator = new ListGenerator<>(random, elementGenerator, 0, 50);
        return listGenerator.map(Arrays::ofList);
    }

    @Override
    protected Comparator<Double> comparator() {
        return Comparator.naturalOrder();
    }
}