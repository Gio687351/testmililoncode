package refactula.design.patterns.structural.proxy.property;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Is a Proxy in relationship to underlying delegate - controls multi-threaded access to the resource.
 */
public class BlockingAccessProperty<T> extends LockingProperty<T> {
    private final ReentrantLock lock;

    public BlockingAccessProperty(ReentrantLock lock, Property<T> delegate) {
        super(delegate);
        this.lock = lock;
    }

    @Override
    protected void unlock() {
        lock.unlock();
    }

    @Override
    protected void lock() {
        lock.lock();
    }
}
