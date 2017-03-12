package refactula.introduction_to_algorithms;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.comparator.ComparatorAdapter;
import refactula.introduction_to_algorithms.utils.generator.Generator;
import refactula.introduction_to_algorithms.utils.generator.IntegerGenerator;
import refactula.introduction_to_algorithms.utils.generator.ListGenerator;

import java.util.Random;

public abstract class IntArraySortTest extends SortingTest<Integer> {

    @Override
    protected final Generator<Array<Integer>> arrayGenerator() {
        Random random = new Random(753951);
        IntegerGenerator elementGenerator = new IntegerGenerator(random, minElement(), maxElement());
        ListGenerator<Integer> listGenerator = new ListGenerator<>(random, elementGenerator, minArraySize(), maxArraySize());
        return listGenerator.map(Arrays::ofList);
    }

    @Override
    protected final Comparator<Integer> comparator() {
        return ComparatorAdapter.naturalOrder();
    }

    protected int maxArraySize() {
        return 1000;
    }

    protected int minArraySize() {
        return 0;
    }

    protected int maxElement() {
        return 10000;
    }

    protected int minElement() {
        return -10000;
    }

}
