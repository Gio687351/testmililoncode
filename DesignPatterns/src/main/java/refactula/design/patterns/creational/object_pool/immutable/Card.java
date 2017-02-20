package refactula.design.patterns.creational.object_pool.immutable;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class Card {
    private final Rank rank;
    private final Suit suit;

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() {
        return rank;
    }

    public Suit suit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rank, suit);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("rank", rank)
                .add("suit", suit)
                .toString();
    }
}
