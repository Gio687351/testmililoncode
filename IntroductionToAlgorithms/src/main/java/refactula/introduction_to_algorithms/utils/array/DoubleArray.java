package refactula.introduction_to_algorithms.utils.array;

class DoubleArray implements Array<Double> {
    private final double[] delegate;

    DoubleArray(double[] delegate) {
        this.delegate = delegate;
    }

    @Override
    public int length() {
        return delegate.length;
    }

    @Override
    public void set(int index, Double value) {
        delegate[index] = value;
    }

    @Override
    public Double get(int index) {
        return delegate[index];
    }
}
