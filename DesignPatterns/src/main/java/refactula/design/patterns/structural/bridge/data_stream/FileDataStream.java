package refactula.design.patterns.structural.bridge.data_stream;

import refactula.design.patterns.structural.bridge.DataStream;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileDataStream implements DataStream {
    private final Path path;

    public static FileDataStream fromFile(File file) {
        return new FileDataStream(file.toPath());
    }

    public FileDataStream(Path path) {
        this.path = path;
    }

    @Override
    public void write(byte[] data) {
        try {
            Files.write(path, data, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
