package refactula.design.patterns.structural.flyweight.card;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

public final class Card {

    public enum Rank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
    }

    public enum Suit {
        DIAMOND,
        CLUB,
        HEART,
        SPADE,
    }

    private static final int RANKS_COUNT = Rank.values().length;
    private static final ImmutableList<Card> POOL = makePool();

    private final Rank rank;
    private final Suit suit;

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    private static ImmutableList<Card> makePool() {
        Rank[] ranks = Rank.values();
        Suit[] suits = Suit.values();
        Card[] cards = new Card[ranks.length * suits.length];
        for (Rank rank : ranks) {
            for (Suit suit : suits) {
                cards[poolIndex(rank, suit)] = new Card(rank, suit);
            }
        }
        return ImmutableList.copyOf(cards);
    }

    private static int poolIndex(Rank rank, Suit suit) {
        return rank.ordinal() + suit.ordinal() * RANKS_COUNT;
    }

    public static Card of(Rank rank, Suit suit) {
        return POOL.get(poolIndex(rank, suit));
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
