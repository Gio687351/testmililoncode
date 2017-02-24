package refactula.design.patterns.structural.proxy.property;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Is a Proxy in relationship to underlying delegate - controls multi-process access to the resource.
 */
public class FileLockingProperty<T> extends LockingProperty<T> {
    private final Path lockFile;
    private final RetryListener retryListener;

    public FileLockingProperty(Path lockFile, RetryListener retryListener, Property<T> delegate) {
        super(delegate);
        this.lockFile = lockFile;
        this.retryListener = retryListener;
    }

    @Override
    protected void lock() {
        try {
            while (true) {
                try {
                    Files.createFile(lockFile);
                    return;
                } catch (FileAlreadyExistsException ignored) {
                    retryListener.onRetry();
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    protected void unlock() {
        try {
            Files.delete(lockFile);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public interface RetryListener {
        void onRetry();
    }
}
