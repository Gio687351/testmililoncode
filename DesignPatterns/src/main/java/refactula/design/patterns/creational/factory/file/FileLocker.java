package refactula.design.patterns.creational.factory.file;

import java.io.File;

public class FileLocker {
    private final FileSystem fileSystem;
    private final RetrySleeper retrySleeper;

    public FileLocker(FileSystem fileSystem, RetrySleeper retrySleeper) {
        this.fileSystem = fileSystem;
        this.retrySleeper = retrySleeper;
    }

    public void lock(File lockFile) {
        while (!fileSystem.createFile(lockFile)) {
            retrySleeper.sleep();
        }
    }

    public void unlock(File file) {
        fileSystem.deleteFile(file);
    }
}
