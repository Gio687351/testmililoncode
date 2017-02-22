package refactula.design.patterns.structural.decorator.data_stream;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class PathDataStream implements DataStream {
    private final Path path;

    public PathDataStream(Path path) {
        this.path = path;
    }

    @Override
    public void writeBytes(byte[] bytes) {
        try {
            Files.write(path, bytes, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
