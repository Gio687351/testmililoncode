package refactula.introduction_to_algorithms.stack;

public class LinkedStack<T> implements Stack<T> {
    private LinkedStackNode<T> head = null;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(T value) {
        head = LinkedStackNode.create(value, head);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T result = head.getValue();
        head = head.getNext();
        return result;
    }
}
