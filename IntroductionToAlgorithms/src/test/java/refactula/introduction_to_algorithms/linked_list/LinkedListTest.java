package refactula.introduction_to_algorithms.linked_list;

import java.util.function.Supplier;

public class LinkedListTest extends AbstractLinkedListTest<Object> {

    @Override
    protected TestableLinkedList<Object> createLinkedList() {
        return new LinkedListAdapter<>(new LinkedList<>());
    }

    @Override
    protected Supplier<Object> elementGenerator() {
        return Object::new;
    }
    
}