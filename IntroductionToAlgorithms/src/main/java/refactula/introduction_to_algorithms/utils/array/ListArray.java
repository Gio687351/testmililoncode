package refactula.introduction_to_algorithms.utils.array;

import java.util.List;

class ListArray<T> extends AbstractArray<T> {
    private final List<T> delegate;

    public ListArray(List<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.size();
    }

    @Override
    public T get(int index) {
        return delegate.get(index);
    }

    @Override
    public void set(int index, T value) {
        delegate.set(index, value);
    }
}
