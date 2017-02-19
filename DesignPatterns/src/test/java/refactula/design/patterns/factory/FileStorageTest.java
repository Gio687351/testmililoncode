package refactula.design.patterns.factory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;

public class FileStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        try {
            return StorageFactory.createFile(Files.createTempDirectory("FileStorageTest").toFile());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
