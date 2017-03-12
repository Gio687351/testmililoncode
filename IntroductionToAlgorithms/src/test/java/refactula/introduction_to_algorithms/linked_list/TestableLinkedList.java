package refactula.introduction_to_algorithms.linked_list;

public interface TestableLinkedList<T> {

    void pushFirst(T value);

    void pushLast(T value);

    T pollFirst();

    T pollLast();

}
