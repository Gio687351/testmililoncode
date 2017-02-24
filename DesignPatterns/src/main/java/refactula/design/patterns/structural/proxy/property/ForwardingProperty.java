package refactula.design.patterns.structural.proxy.property;

import java.util.function.Function;

public class ForwardingProperty<T> implements Property<T> {
    private final Property<T> delegate;

    public ForwardingProperty(Property<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T get() {
        return delegate.get();
    }

    @Override
    public void set(T newValue) {
        delegate.set(newValue);
    }

    @Override
    public void update(Function<T, T> atomicUpdater) {
        delegate.update(atomicUpdater);
    }
}
