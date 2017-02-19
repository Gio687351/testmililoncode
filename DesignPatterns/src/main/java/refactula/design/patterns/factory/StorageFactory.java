package refactula.design.patterns.factory;

import refactula.design.patterns.factory.file.*;

import java.io.File;

/**
 * Factory design pattern.
 * Provides methods for creating different types of Storage.
 * Which method to call is decided by user.
 */
public class StorageFactory {
    private StorageFactory() { /* private constructor */}

    public static Storage createForgetful() {
        return ForgetfulStorage.INTANCE;
    }

    public static Storage createInMemory() {
        return new InMemoryStorage();
    }

    public static Storage createFile(File folder) {
        StringConverter stringConverter = StringConverter.UTF_8;
        StringEncoder encoder = new StringEncoder(stringConverter);
        FileStorageFolder fileStorageFolder = new FileStorageFolder(folder, encoder);
        RuntimeExceptionFactory exceptionFactory = new FileStorageExceptionFactory();
        FileSystem fileSystem = new FileSystem(exceptionFactory);
        RetrySleeper retrySleeper = new RetrySleeper(100L, exceptionFactory);
        FileLocker fileLocker = new FileLocker(fileSystem, retrySleeper);
        FileIO fileIO = new FileIO(stringConverter, exceptionFactory);
        return new FileStorage(fileStorageFolder, fileLocker, fileIO);
    }
}
