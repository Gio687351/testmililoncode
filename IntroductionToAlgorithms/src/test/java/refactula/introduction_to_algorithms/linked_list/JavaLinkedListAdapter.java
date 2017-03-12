package refactula.introduction_to_algorithms.linked_list;

public class JavaLinkedListAdapter<T> implements TestableLinkedList<T> {
    private final java.util.LinkedList<T> adaptee;

    public static <T> JavaLinkedListAdapter<T> create() {
        return new JavaLinkedListAdapter<>(new java.util.LinkedList<>());
    }

    public JavaLinkedListAdapter(java.util.LinkedList<T> adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void pushFirst(T value) {
        adaptee.addFirst(value);
    }

    @Override
    public void pushLast(T value) {
        adaptee.addLast(value);
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
