package refactula.introduction_to_algorithms.hash_table;

import com.google.common.base.Preconditions;
import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;

public class HashTable<T> {
    private Array<HashNode<T>> nodes = createNodesArray(16);
    private int size = 0;

    private static <T> Array<HashNode<T>> createNodesArray(int size) {
        Array<HashNode<T>> array = Arrays.ofObjects(size);
        for (int i = 0; i < array.length(); i++) {
            array.set(i, new HashNode<>(null));
        }
        return array;
    }

    public boolean insert(T element) {
        Preconditions.checkNotNull(element);
        HashNode<T> predecessor = searchPredecessor(element);
        if (predecessor.next() != null) {
            return false;
        }
        predecessor.setNext(new HashNode<>(element));
        size++;
        ensureCapacity();
        return true;
    }

    public boolean contains(T element) {
        Preconditions.checkNotNull(element);
        return searchPredecessor(element).next() != null;
    }

    public boolean remove(T element) {
        Preconditions.checkNotNull(element);
        HashNode<T> predecessor = searchPredecessor(element);
        if (predecessor.next() == null) {
            return false;
        }
        predecessor.setNext(predecessor.next().next());
        size--;
        return true;
    }

    private HashNode<T> searchPredecessor(T element) {
        HashNode<T> predecessor = listHead(element);
        while (predecessor.next() != null) {
            if (predecessor.next().element().equals(element)) {
                return predecessor;
            }
            predecessor = predecessor.next();
        }
        return predecessor;
    }

    private HashNode<T> listHead(T element) {
        return nodes.get(element.hashCode() % nodes.length());
    }

    private void ensureCapacity() {
        int capacity = nodes.length();
        if (size <= capacity) {
            return;
        }
        Array<HashNode<T>> oldNodes = nodes;
        nodes = createNodesArray(Math.max(capacity * 2, size));
        size = 0;
        for (int i = 0; i < oldNodes.length(); i++) {
            for (HashNode<T> node = oldNodes.get(i).next(); node != null; node = node.next()) {
                insert(node.element());
            }
        }
    }
}
