package refactula.design.patterns.factory.file;

import java.io.File;
import java.io.IOException;

public class FileSystem {
    private final RuntimeExceptionFactory exceptionFactory;

    public FileSystem(RuntimeExceptionFactory exceptionFactory) {
        this.exceptionFactory = exceptionFactory;
    }

    public boolean createFile(File file) {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw exceptionFactory.throwBecause("Failed to create a file", e);
        }
    }

    public void deleteFile(File file) {
        file.delete();
    }
}
