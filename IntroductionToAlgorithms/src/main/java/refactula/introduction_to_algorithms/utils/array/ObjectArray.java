package refactula.introduction_to_algorithms.utils.array;

class ObjectArray<T> implements Array<T> {
    private final T[] delegate;

    ObjectArray(T[] delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.length;
    }

    @Override
    public void set(int index, T value) {
        delegate[index] = value;
    }

    @Override
    public T get(int index) {
        return delegate[index];
    }
}
