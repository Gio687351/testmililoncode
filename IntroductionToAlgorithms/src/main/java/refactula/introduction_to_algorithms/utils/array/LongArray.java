package refactula.introduction_to_algorithms.utils.array;

class LongArray implements Array<Long> {
    private final long[] delegate;

    LongArray(long[] delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.length;
    }

    @Override
    public void set(int index, Long value) {
        delegate[index] = value;
    }

    @Override
    public Long get(int index) {
        return delegate[index];
    }
}
