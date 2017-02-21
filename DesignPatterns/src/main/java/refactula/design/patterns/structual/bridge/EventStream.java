package refactula.design.patterns.structual.bridge;

/**
 * Represents <i>abstraction</i> in Bridge design pattern, decoupled from implementation.
 *
 * @see DataStream DataStream - independent implementation interface
 */
public interface EventStream {

    void recordEvent(String event);

}
