package refactula.design.patterns.creational.factory.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileIO {
    private final StringConverter stringConverter;
    private final RuntimeExceptionFactory exceptionFactory;

    public FileIO(StringConverter stringConverter, RuntimeExceptionFactory exceptionFactory) {
        this.stringConverter = stringConverter;
        this.exceptionFactory = exceptionFactory;
    }

    public void write(File file, String content) {
        try {
            Files.write(file.toPath(), stringConverter.getBytes(content));
        } catch (IOException e) {
            throw exceptionFactory.throwBecause("Failed to write to file", e);
        }
    }

    public String read(File file) {
        if (!file.exists()) {
            return null;
        }
        try {
            return stringConverter.toString(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw exceptionFactory.throwBecause("Failed to read from file", e);
        }
    }
}
