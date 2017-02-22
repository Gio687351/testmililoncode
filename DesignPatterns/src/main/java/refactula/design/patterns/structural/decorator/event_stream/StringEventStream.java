package refactula.design.patterns.structural.decorator.event_stream;

import refactula.design.patterns.structural.decorator.line_stream.LineStream;

import java.util.function.Function;

public class StringEventStream<E> implements EventStream<E> {
    private final LineStream lineStream;
    private final Function<E, String> serializer;

    public StringEventStream(Function<E, String> serializer, LineStream lineStream) {
        this.lineStream = lineStream;
        this.serializer = serializer;
    }

    @Override
    public void recordEvent(E event) {
        lineStream.printLine(serializer.apply(event));
    }
}
