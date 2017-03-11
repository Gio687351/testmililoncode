package refactula.introduction_to_algorithms.utils.array;

class FloatArray implements Array<Float> {
    private final float[] delegate;

    FloatArray(float[] delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.length;
    }

    @Override
    public void set(int index, Float value) {
        delegate[index] = value;
    }

    @Override
    public Float get(int index) {
        return delegate[index];
    }
}
