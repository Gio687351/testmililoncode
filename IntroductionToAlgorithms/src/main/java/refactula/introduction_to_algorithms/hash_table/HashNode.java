package refactula.introduction_to_algorithms.hash_table;

public class HashNode<T> {
    private final T element;
    private HashNode<T> next;

    public HashNode(T element) {
        this.element = element;
    }

    public T element() {
        return element;
    }

    public HashNode<T> next() {
        return next;
    }

    public HashNode<T> setNext(HashNode<T> next) {
        this.next = next;
        return this;
    }
}
