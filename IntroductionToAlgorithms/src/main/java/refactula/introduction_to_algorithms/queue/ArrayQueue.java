package refactula.introduction_to_algorithms.queue;

import refactula.introduction_to_algorithms.utils.array.Array;
import refactula.introduction_to_algorithms.utils.array.Arrays;

public class ArrayQueue<T> implements Queue<T> {
    private Array<T> array = Arrays.ofObjects(16);
    private int head = 0;
    private int size = 0;

    @Override
    public void enqueue(T element) {
        ensureCapacity(size + 1);
        array.set((head + size++) % array.length(), element);
    }

    private void ensureCapacity(int capacity) {
        if (array.length() >= capacity) {
            return;
        }
        int newCapacity = Math.max(array.length() * 2, capacity);
        Array<T> newArray = Arrays.ofObjects(newCapacity);
        for (int i = 0; i < size; i++) {
            newArray.set(i, array.get((head + i) % array.length()));
        }
        array = newArray;
        head = 0;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T element = array.get(head);
        head = (head + 1) % array.length();
        size--;
        return element;
    }
}
