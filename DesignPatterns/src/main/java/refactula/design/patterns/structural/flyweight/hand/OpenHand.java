package refactula.design.patterns.structural.flyweight.hand;

import com.google.common.base.Objects;
import refactula.design.patterns.structural.flyweight.card.Card;
import refactula.design.patterns.structural.flyweight.utils.Openable;
import refactula.design.patterns.structural.flyweight.utils.Openable.Open;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.ImmutableList.toImmutableList;

public class OpenHand implements Hand {
    private final List<Open<Card>> cards;

    public static OpenHand of(Card... cards) {
        return new OpenHand(Arrays.stream(cards)
                .map(Openable::open)
                .collect(toImmutableList()));
    }

    public OpenHand(List<Open<Card>> cards) {
        this.cards = cards;
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Open<Card> getCard(int index) {
        return cards.get(index);
    }

    @Override
    public Hand closed() {
        return ClosedHand.ofSize(size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenHand openHand = (OpenHand) o;
        return Objects.equal(cards, openHand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cards);
    }
}
