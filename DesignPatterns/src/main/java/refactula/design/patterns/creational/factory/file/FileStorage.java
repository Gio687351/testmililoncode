package refactula.design.patterns.creational.factory.file;

import refactula.design.patterns.creational.factory.Storage;

import java.io.File;

public class FileStorage implements Storage {
    private final FileStorageFolder folder;
    private final FileLocker fileLocker;
    private final FileIO fileIO;

    public FileStorage(FileStorageFolder folder, FileLocker fileLocker, FileIO fileIO) {
        this.folder = folder;
        this.fileLocker = fileLocker;
        this.fileIO = fileIO;
    }

    @Override
    public void store(String key, String value) {
        String encodedKey = folder.encodeKey(key);
        File lockFile = folder.getLockFile(encodedKey);
        fileLocker.lock(lockFile);
        try {
            File storageFile = folder.getStorageFile(encodedKey);
            fileIO.write(storageFile, value);
        } finally {
            fileLocker.unlock(lockFile);
        }
    }

    @Override
    public String retrieve(String key) {
        String encodedKey = folder.encodeKey(key);
        File lockFile = folder.getLockFile(key);
        fileLocker.lock(lockFile);
        try {
            File storageFile = folder.getStorageFile(encodedKey);
            return fileIO.read(storageFile);
        } finally {
            fileLocker.unlock(lockFile);
        }
    }
}
