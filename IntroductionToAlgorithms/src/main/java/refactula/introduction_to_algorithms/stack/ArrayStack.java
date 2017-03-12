package refactula.introduction_to_algorithms.stack;

import java.util.ArrayList;

public class ArrayStack<T> implements Stack<T> {
    private final ArrayList<T> array = new ArrayList<T>();

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(T value) {
        array.add(value);
    }

    @Override
    public T pop() {
        return isEmpty() ? null : array.remove(array.size() - 1);
    }
}
