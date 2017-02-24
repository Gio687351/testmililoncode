package refactula.design.patterns.structural.flyweight.hand;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import refactula.design.patterns.structural.flyweight.utils.Openable;
import refactula.design.patterns.structural.flyweight.utils.Openable.Closed;
import refactula.design.patterns.structural.flyweight.card.Card;

import java.util.stream.IntStream;

public class ClosedHand implements Hand {
    private static final ImmutableList<ClosedHand> POOL = IntStream.range(0, 55)
            .mapToObj(ClosedHand::new)
            .collect(ImmutableList.toImmutableList());

    private final int size;

    public static ClosedHand ofSize(int size) {
        return size < POOL.size() ? POOL.get(size) : new ClosedHand(size);
    }

    private ClosedHand(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Closed<Card> getCard(int index) {
        return Openable.closed();
    }

    @Override
    public Hand closed() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClosedHand that = (ClosedHand) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }
}
