package refactula.introduction_to_algorithms.order_statistics;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;
import refactula.introduction_to_algorithms.utils.generator.ArrayGenerator;
import refactula.introduction_to_algorithms.utils.generator.IntegerGenerator;
import refactula.introduction_to_algorithms.utils.generator.ListGenerator;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class OrderStatisticsTest {

    @Test
    public void testElement() {
        Random random = new Random(753951);
        IntegerGenerator elementGenerator = new IntegerGenerator(random, -10000, 10000);
        ListGenerator<Integer> listGenerator = new ListGenerator<>(random, elementGenerator, 1, 100);
        ArrayGenerator<Integer> arrayGenerator = new ArrayGenerator<>(listGenerator);
        Comparator<Integer> c = Comparator.naturalOrder();
        int samples = 10000;
        for (int i = 0; i < samples; i++) {
            Array<Integer> a = arrayGenerator.generate();
            Array<Integer> sorted = Arrays.ofList(Arrays.asList(a).stream()
                    .sorted()
                    .collect(ImmutableList.toImmutableList()));
            int k = random.nextInt(a.length());
            assertEquals(sorted.get(k), OrderStatistics.get(a, c, k));
        }
    }

}
