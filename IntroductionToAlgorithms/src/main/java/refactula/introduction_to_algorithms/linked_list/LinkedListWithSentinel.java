package refactula.introduction_to_algorithms.linked_list;

import java.util.Objects;

public class LinkedListWithSentinel<T> {
    private final LinkedNode<T> nil;

    public LinkedListWithSentinel() {
        nil = LinkedNode.create(null);
        attach(nil, nil);
    }

    public LinkedNode<T> search(T value) {
        for (LinkedNode<T> node = nil.next(); node != nil; node = node.next()) {
            if (Objects.equals(node.value(), value)) {
                return node;
            }
        }
        return null;
    }

    public void insertFirst(LinkedNode<T> node) {
        insertAfter(nil, node);
    }

    public void insertLast(LinkedNode<T> node) {
        insertAfter(nil.prev(), node);
    }

    private void insertAfter(LinkedNode<T> node, LinkedNode<T> newNode) {
        attach(newNode, node.next());
        attach(node, newNode);
    }

    private void attach(LinkedNode<T> first, LinkedNode<T> second) {
        first.setNext(second);
        second.setPrev(first);
    }

    public void delete(LinkedNode<T> node) {
        node.prev().setNext(node.next());
        node.next().setPrev(node.prev());
    }

    public void pushFirst(T value) {
        insertFirst(LinkedNode.create(value));
    }

    public void pushLast(T value) {
        insertLast(LinkedNode.create(value));
    }

    public T pollFirst() {
        if (nil.next() == nil) {
            return null;
        }
        T first = nil.next().value();
        delete(nil.next());
        return first;
    }

    public T pollLast() {
        if (nil.prev() == nil) {
            return null;
        }
        T last = nil.prev().value();
        delete(nil.prev());
        return last;
    }
}
