package refactula.introduction_to_algorithms.linked_list;

public class LinkedListAdapter<T> implements TestableLinkedList<T> {
    private final LinkedList<T> adaptee;

    public LinkedListAdapter(LinkedList<T> adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void pushFirst(T value) {
        adaptee.pushFirst(value);
    }

    @Override
    public void pushLast(T value) {
        adaptee.pushLast(value);
    }

    @Override
    public T pollFirst() {
        return adaptee.pollFirst();
    }

    @Override
    public T pollLast() {
        return adaptee.pollLast();
    }
}
