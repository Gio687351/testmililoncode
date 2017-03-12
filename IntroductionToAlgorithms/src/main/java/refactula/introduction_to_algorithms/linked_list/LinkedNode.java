package refactula.introduction_to_algorithms.linked_list;

public class LinkedNode<T> {
    private LinkedNode<T> prev;
    private LinkedNode<T> next;
    private T value;

    public static <T> LinkedNode<T> create(T value) {
        return create(null, value, null);
    }

    public static <T> LinkedNode<T> create(LinkedNode<T> prev, T value, LinkedNode<T> next) {
        LinkedNode<T> node = new LinkedNode<>();
        node.prev = prev;
        node.value = value;
        node.next = next;
        return node;
    }

    public LinkedNode<T> prev() {
        return prev;
    }

    public T value() {
        return value;
    }

    public LinkedNode<T> next() {
        return next;
    }

    public void setPrev(LinkedNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
