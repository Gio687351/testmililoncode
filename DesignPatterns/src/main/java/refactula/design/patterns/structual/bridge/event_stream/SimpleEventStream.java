package refactula.design.patterns.structual.bridge.event_stream;

import refactula.design.patterns.structual.bridge.DataStream;
import refactula.design.patterns.structual.bridge.EventStream;

import java.nio.charset.StandardCharsets;

public class SimpleEventStream implements EventStream {
    private final DataStream dataStream;

    public SimpleEventStream(DataStream dataStream) {
        this.dataStream = dataStream;
    }

    @Override
    public final void recordEvent(String event) {
        dataStream.write(event.getBytes(StandardCharsets.UTF_8));
    }
}
