package refactula.introduction_to_algorithms.linked_list;

import java.util.Objects;

public class LinkedList<T> {
    private LinkedNode<T> head = null;
    private LinkedNode<T> tail = null;

    public LinkedNode<T> search(T value) {
        for (LinkedNode<T> node = head; node != null; node = node.next()) {
            if (Objects.equals(node.value(), value)) {
                return node;
            }
        }
        return null;
    }

    public void insertFirst(LinkedNode<T> node) {
        if (head != null) {
            attach(node, head);
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    public void insertLast(LinkedNode<T> node) {
        if (tail != null) {
            attach(tail, node);
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    private void attach(LinkedNode<T> first, LinkedNode<T> second) {
        first.setNext(second);
        second.setPrev(first);
    }

    public void delete(LinkedNode<T> node) {
        if (node == tail) {
            tail = node.prev();
        }
        if (node == head) {
            head = node.next();
        }
        if (node.prev() != null) {
            node.prev().setNext(node.next());
        }
        if (node.next() != null) {
            node.next().setPrev(node.prev());
        }
    }

    public void pushFirst(T value) {
        insertFirst(LinkedNode.create(value));
    }

    public void pushLast(T value) {
        insertLast(LinkedNode.create(value));
    }

    public T pollFirst() {
        if (head == null) {
            return null;
        }
        T first = head.value();
        delete(head);
        return first;
    }

    public T pollLast() {
        if (tail == null) {
            return null;
        }
        T last = tail.value();
        delete(tail);
        return last;
    }
}
