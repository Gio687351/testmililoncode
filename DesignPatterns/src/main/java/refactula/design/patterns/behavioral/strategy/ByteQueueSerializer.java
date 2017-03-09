package refactula.design.patterns.behavioral.strategy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.util.Base64;

public enum ByteQueueSerializer implements QueueSerializer {
    INSTANCE;

    @Override
    public String serialize(QueueMessage message) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(buffer)) {
            out.writeObject(message);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return Base64.getEncoder().encodeToString(buffer.toByteArray());
    }
}
