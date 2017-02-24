package refactula.design.patterns.structural.proxy.property;

import java.util.function.Function;

public abstract class LockingProperty<T> extends ForwardingProperty<T> {
    public LockingProperty(Property<T> delegate) {
        super(delegate);
    }

    protected abstract void lock();

    protected abstract void unlock();

    @Override
    public T get() {
        lock();
        try {
            return super.get();
        } finally {
            unlock();
        }
    }

    @Override
    public void set(T newValue) {
        lock();
        try {
            super.set(newValue);
        } finally {
            unlock();
        }
    }

    @Override
    public void update(Function<T, T> atomicUpdater) {
        lock();
        try {
            super.update(atomicUpdater);
        } finally {
            unlock();
        }
    }
}
