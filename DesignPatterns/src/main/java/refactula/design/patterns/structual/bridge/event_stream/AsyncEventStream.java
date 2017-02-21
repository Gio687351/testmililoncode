package refactula.design.patterns.structual.bridge.event_stream;

import refactula.design.patterns.structual.bridge.DataStream;
import refactula.design.patterns.structual.bridge.EventStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AsyncEventStream implements EventStream {
    private final DataStream dataStream;
    private final Queue<String> eventQueue = new ConcurrentLinkedQueue<>();

    public AsyncEventStream(DataStream dataStream) {
        this.dataStream = dataStream;
    }

    @Override
    public void recordEvent(String event) {
        eventQueue.add(event);
    }

    public void flush() {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        String event;
        while ((event = eventQueue.poll()) != null) {
            try {
                byteBuffer.write(event.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        dataStream.write(byteBuffer.toByteArray());
    }
}
