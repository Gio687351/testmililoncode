package refactula.argorithms.data.structure.immutable;

import com.google.common.base.Preconditions;

public class Stack<T> {
    private final T head;
    private final Stack<T> tail;

    public Stack(T head, Stack<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public T getHead() {
        return head;
    }

    public boolean hasTail() {
        return tail != null;
    }

    public Stack<T> getTail() {
        Preconditions.checkState(hasTail());
        return tail;
    }
}
