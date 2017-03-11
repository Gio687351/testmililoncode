package refactula.introduction_to_algorithms.insertion_sort;

import refactula.introduction_to_algorithms.AbstractSortTest;
import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.comparator.ComparatorAdapter;
import refactula.introduction_to_algorithms.utils.generator.Generator;
import refactula.introduction_to_algorithms.utils.generator.IntegerGenerator;
import refactula.introduction_to_algorithms.utils.generator.ListGenerator;
import refactula.introduction_to_algorithms.utils.sorting.SortingAlgorithm;

import java.util.Random;

public class InsertionSortTest extends AbstractSortTest<Integer> {

    @Override
    protected SortingAlgorithm<Integer> sortingAlgorithm() {
        return new InsertionSort<>();
    }

    @Override
    protected Generator<Array<Integer>> arrayGenerator() {
        Random random = new Random(753951);
        IntegerGenerator elementGenerator = new IntegerGenerator(random, -1000, 1000);
        ListGenerator<Integer> listGenerator = new ListGenerator<>(random, elementGenerator, 0, 1000);
        return listGenerator.map(Arrays::ofList);
    }

    @Override
    protected Comparator<Integer> comparator() {
        return ComparatorAdapter.naturalOrder();
    }

}