package refactula.design.patterns.behavioral.template_method;

public abstract class LockedOperation {

    public final void run() {
        lock();
        try {
            runUnderLock();
        } finally {
            unlock();
        }
    }

    protected abstract void lock();

    protected abstract void unlock();

    protected abstract void runUnderLock();

}
