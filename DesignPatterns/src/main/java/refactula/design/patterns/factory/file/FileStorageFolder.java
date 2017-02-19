package refactula.design.patterns.factory.file;

import java.io.File;

public class FileStorageFolder {
    private final File folder;
    private final StringEncoder encoder;

    public FileStorageFolder(File folder, StringEncoder encoder) {
        this.folder = folder;
        this.encoder = encoder;
    }

    public String encodeKey(String key) {
        return encoder.encode(key);
    }

    public File getLockFile(String encodedKey) {
        return new File(folder, encodedKey + ".lock");
    }

    public File getStorageFile(String encodedKey) {
        return new File(folder, encodedKey);
    }
}
