package refactula.design.patterns.structural.decorator.event_stream;

public interface EventStream<E> {

    void recordEvent(E event);

}
