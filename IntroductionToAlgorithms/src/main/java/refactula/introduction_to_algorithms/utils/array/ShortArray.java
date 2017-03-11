package refactula.introduction_to_algorithms.utils.array;

class ShortArray extends AbstractArray<Short> {
    private final short[] delegate;

    ShortArray(short[] delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.length;
    }

    @Override
    public void set(int index, Short value) {
        delegate[index] = value;
    }

    @Override
    public Short get(int index) {
        return delegate[index];
    }
}
