package refactula.design.patterns.structual.bridge;

/**
 * Represents <i>implementation</i> in Bridge design pattern, independent of abstraction.
 *
 * @see EventStream EventStream - decoupled abstraction interface
 */
public interface DataStream {

    void write(byte[] data);

}
