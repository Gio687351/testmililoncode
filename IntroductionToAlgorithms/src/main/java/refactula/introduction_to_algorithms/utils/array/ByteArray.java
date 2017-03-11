package refactula.introduction_to_algorithms.utils.array;

class ByteArray extends AbstractArray<Byte> {
    private final byte[] delegate;

    ByteArray(byte[] delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.length;
    }

    @Override
    public void set(int index, Byte value) {
        delegate[index] = value;
    }

    @Override
    public Byte get(int index) {
        return delegate[index];
    }
}
