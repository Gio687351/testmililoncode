package refactula.design.patterns.behavioral.template_method;

import com.google.common.base.Preconditions;

import java.util.concurrent.locks.ReentrantLock;

public abstract class SynchronizedOperation extends LockedOperation {
    private final ReentrantLock lock;

    protected SynchronizedOperation(ReentrantLock lock) {
        this.lock = Preconditions.checkNotNull(lock);
    }

    @Override
    protected final void lock() {
        lock.lock();
    }

    @Override
    protected final void unlock() {
        lock.unlock();
    }
}
