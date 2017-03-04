package refacutula.poker;

import com.google.common.collect.ImmutableList;

public final class Card {
    private final Rank rank;
    private final Suit suit;

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card of(Rank rank, Suit suit) {
        return Pool.get(rank, suit);
    }

    public Rank rank() {
        return rank;
    }

    public Suit suit() {
        return suit;
    }

    private static final class Pool {
        private static final int RANKS_COUNT = Rank.values().length;
        private static final int SUITS_COUNT = Suit.values().length;

        private static final ImmutableList<Card> CARDS = createCards();

        private static Card get(Rank rank, Suit suit) {
            return CARDS.get(indexOf(rank, suit));
        }

        private static ImmutableList<Card> createCards() {
            Card[] buffer = new Card[RANKS_COUNT * SUITS_COUNT];
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    buffer[indexOf(rank, suit)] = new Card(rank, suit);
                }
            }
            return ImmutableList.copyOf(buffer);
        }

        private static int indexOf(Rank rank, Suit suit) {
            return rank.ordinal() + suit.ordinal() * RANKS_COUNT;
        }
    }
}
