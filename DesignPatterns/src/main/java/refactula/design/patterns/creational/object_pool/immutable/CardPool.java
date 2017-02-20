package refactula.design.patterns.creational.object_pool.immutable;

public class CardPool {
    private static final int RANKS_COUNT = Rank.values().length;
    private static final int SUITS_COUNT = Suit.values().length;
    private static final Card[] ALL_CARDS = createCardsArray();

    private static Card[] createCardsArray() {
        Card[] cards = new Card[RANKS_COUNT * SUITS_COUNT];
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards[indexOf(rank, suit)] = new Card(rank, suit);
            }
        }
        return cards;
    }

    public static Card card(Rank rank, Suit suit) {
        return ALL_CARDS[indexOf(rank, suit)];
    }

    private static int indexOf(Rank rank, Suit suit) {
        return rank.ordinal() + suit.ordinal() * RANKS_COUNT;
    }
}
