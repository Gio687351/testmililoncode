package refactula.introduction_to_algorithms.linked_list;

import java.util.function.Supplier;

public class LinkedListWithSentinelTest extends AbstractLinkedListTest<Object> {

    @Override
    protected TestableLinkedList<Object> createLinkedList() {
        return new LinkedListWithSentinelAdapter<>(new LinkedListWithSentinel<>());
    }

    @Override
    protected Supplier<Object> elementGenerator() {
        return Object::new;
    }

}