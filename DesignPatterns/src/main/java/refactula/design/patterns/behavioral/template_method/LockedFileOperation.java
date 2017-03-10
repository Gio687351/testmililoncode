package refactula.design.patterns.behavioral.template_method;

import com.google.common.base.Preconditions;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

public abstract class LockedFileOperation extends LockedOperation {
    private final File lock;

    public LockedFileOperation(File lockDir) {
        this.lock = Preconditions.checkNotNull(lockDir);
    }

    @Override
    protected void lock() {
        try {
            while (!lock.createNewFile()) {
                Thread.sleep(10);
            }
            lock.deleteOnExit();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    protected void unlock() {
        lock.delete();
    }
}
