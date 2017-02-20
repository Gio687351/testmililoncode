package refactula.design.patterns.creational.factory.file;

public class FileStorageExceptionFactory implements RuntimeExceptionFactory {
    @Override
    public FileStorageException throwBecause(String message) {
        throw new FileStorageException(message);
    }

    @Override
    public FileStorageException throwBecause(String message, Throwable cause) {
        throw new FileStorageException(message, cause);
    }
}
