package refactula.design.patterns.structural.decorator.event_stream;

import refactula.design.patterns.structural.decorator.data_stream.DataStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UncheckedIOException;

public class SerializedEventStream<E extends Serializable> implements EventStream<E> {
    private final DataStream dataStream;

    public SerializedEventStream(DataStream dataStream) {
        this.dataStream = dataStream;
    }

    @Override
    public void recordEvent(E event) {
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(event);
            dataStream.writeBytes(buffer.toByteArray());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
