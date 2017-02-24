package refactula.design.patterns.structural.proxy.property;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UncheckedIOException;

@SuppressWarnings("ALL")
public class SerializableProperty<T extends Serializable> implements Property<T> {
    private final Property<byte[]> delegate;

    public SerializableProperty(Property<byte[]> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T get() {
        byte[] buffer = delegate.get();
        if (buffer == null) {
            return null;
        }
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer))) {
            return (T) in.readObject();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void set(T newValue) {
        if (newValue == null) {
            delegate.set(null);
            return;
        }
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(buffer)) {
                objectOutputStream.writeObject(newValue);
                objectOutputStream.flush();
                delegate.set(buffer.toByteArray());
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
