package refactula.introduction_to_algorithms.linked_list;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.Assert.*;

public abstract class AbstractLinkedListTest<T> {

    protected abstract TestableLinkedList<T> createLinkedList();

    protected abstract Supplier<T> elementGenerator();

    @Test
    public void testLinkedList() {
        Random random = new Random("LinkedList".hashCode());
        for (int i = 0, samples = samples(); i < samples; i++) {
            Supplier<T> elementGenerator = elementGenerator();
            TestableLinkedList<T> tested = createLinkedList();
            TestableLinkedList<T> correct = JavaLinkedListAdapter.create();
            Tester<T> tester = Tester.create(random, tested, correct, elementGenerator);
            tester.test(1000);
        }
    }

    protected int samples() {
        return 10000;
    }

    private static final class Tester<T> {
        private final Random random;
        private final TestableLinkedList<T> tested;
        private final TestableLinkedList<T> correct;
        private final List<TestOperation> operations;
        private final Supplier<T> elementSupplier;

        private static <T> Tester<T> create(
                Random random,
                TestableLinkedList<T> tested,
                TestableLinkedList<T> correct,
                Supplier<T> elementSupplier) {

            return new Tester<>(
                    random,
                    tested,
                    correct,
                    ImmutableList.copyOf(TestOperation.values()),
                    elementSupplier);
        }

        private Tester(
                Random random,
                TestableLinkedList<T> tested,
                TestableLinkedList<T> correct,
                List<TestOperation> operations,
                Supplier<T> elementSupplier) {

            this.random = random;
            this.tested = tested;
            this.correct = correct;
            this.operations = operations;
            this.elementSupplier = elementSupplier;
        }

        public void test(int operationsAmount) {
            for (int i = 0; i < operationsAmount; i++) {
                randomOperation().doTest(tested, correct, elementSupplier);
            }
        }

        private TestOperation randomOperation() {
            int randomIndex = random.nextInt(operations.size());
            return operations.get(randomIndex);
        }
    }

    private enum TestOperation {
        PUSH_FIRST {
            @Override
            public <T> void doTest(
                    TestableLinkedList<T> tested,
                    TestableLinkedList<T> correct,
                    Supplier<T> elementSupplier) {

                T element = elementSupplier.get();
                tested.pushFirst(element);
                correct.pushFirst(element);
            }
        },

        PUSH_LAST {
            @Override
            public <T> void doTest(
                    TestableLinkedList<T> tested,
                    TestableLinkedList<T> correct,
                    Supplier<T> elementSupplier) {

                T element = elementSupplier.get();
                tested.pushLast(element);
                correct.pushLast(element);
            }
        },

        POLL_FIRST {
            @Override
            public <T> void doTest(
                    TestableLinkedList<T> tested,
                    TestableLinkedList<T> correct,
                    Supplier<T> elementSupplier) {

                T expected = correct.pollFirst();
                T actual = tested.pollFirst();
                assertEquals(expected, actual);
            }
        },

        POLL_LAST {
            @Override
            public <T> void doTest(
                    TestableLinkedList<T> tested,
                    TestableLinkedList<T> correct,
                    Supplier<T> elementSupplier) {

                T expected = correct.pollLast();
                T actual = tested.pollLast();
                assertEquals(expected, actual);
            }
        };

        public abstract <T> void doTest(
                TestableLinkedList<T> tested,
                TestableLinkedList<T> correct,
                Supplier<T> elementSupplier);
    }
}