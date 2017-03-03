package refacutula.poker;

public enum Suit {
    HEARTS("h"),
    SPADES("s"),
    CLUBS("c"),
    DIAMONDS("d");

    private final String string;

    Suit(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
