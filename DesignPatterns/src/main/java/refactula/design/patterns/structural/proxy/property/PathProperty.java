package refactula.design.patterns.structural.proxy.property;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class PathProperty implements Property<byte[]> {
    private final Path path;

    public PathProperty(Path path) {
        this.path = path;
    }

    @Override
    public byte[] get() {
        if (!Files.exists(path)) {
            return null;
        }
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void set(byte[] newValue) {
        try {
            if (newValue == null) {
                Files.delete(path);
                return;
            }
            Files.write(path, newValue);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void update(Function<byte[], byte[]> atomicUpdater) {
        set(atomicUpdater.apply(get()));
    }
}
