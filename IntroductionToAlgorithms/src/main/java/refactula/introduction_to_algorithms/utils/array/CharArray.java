package refactula.introduction_to_algorithms.utils.array;

class CharArray extends AbstractArray<Character> {
    private final char[] delegate;

    CharArray(char[] delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.length;
    }

    @Override
    public void set(int index, Character value) {
        delegate[index] = value;
    }

    @Override
    public Character get(int index) {
        return delegate[index];
    }
}
