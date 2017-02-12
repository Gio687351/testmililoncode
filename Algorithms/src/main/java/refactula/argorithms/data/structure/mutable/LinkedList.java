package refactula.argorithms.data.structure.mutable;

public class LinkedList<T> {
    private final Node<T> beforeHead = new Node<T>();
    private Node<T> tail = beforeHead;

    public void addHead(T value) {
        Node<T> newHead = new Node<>();
        newHead.value = value;
        newHead.next = beforeHead.next;
        beforeHead.next = newHead;
        if (tail.next != null) {
            tail = tail.next;
        }
    }

    public void addTail(T value) {
        Node<T> newTail = new Node<>();
        newTail.value = value;
        tail.next = newTail;
        tail = newTail;
    }

    public T getHead() {
        return beforeHead.next == null ? null : beforeHead.next.value;
    }

    public T getTail() {
        return beforeHead.next == null ? null : tail.value;
    }

    public T pullHead() {
        if (beforeHead.next == null) {
            return null;
        }
        T result = beforeHead.next.value;
        beforeHead.next = beforeHead.next.next;
        return result;
    }

    public T pullTail() {
        if (beforeHead.next == null) {
            return null;
        }
        Node<T> newTail = beforeHead;
        while (newTail.next.next != null) {
            newTail = newTail.next;
        }
        T result = tail.value;
        newTail.next = null;
        tail = newTail;
        return result;
    }

    private static final class Node<T> {
        private T value;
        private Node<T> next;
    }
}
