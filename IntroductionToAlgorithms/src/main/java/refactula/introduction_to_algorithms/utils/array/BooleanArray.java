package refactula.introduction_to_algorithms.utils.array;

class BooleanArray implements Array<Boolean> {
    private final boolean[] delegate;

    BooleanArray(boolean[] delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.length;
    }

    @Override
    public void set(int index, Boolean value) {
        delegate[index] = value;
    }

    @Override
    public Boolean get(int index) {
        return delegate[index];
    }
}
