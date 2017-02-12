package refactula.argorithms.data.structure.mutable;

import refactula.argorithms.data.structure.immutable.Stack;

public class StatefulStack<T> {
    private Stack<T> stack = null;

    public void push(T value) {
        stack = new Stack<>(value, stack);
    }

    public T pop() {
        if (stack == null) {
            return null;
        }
        T head = stack.getHead();
        stack = stack.getTail();
        return head;
    }
}
