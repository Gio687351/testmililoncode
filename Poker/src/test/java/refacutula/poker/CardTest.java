package refacutula.poker;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void aceOfSpadesShouldBeAce() {
        Card card = Card.of(Rank.ACE, Suit.SPADES);
        assertEquals(Rank.ACE, card.rank());
    }

    @Test
    public void aceOfSpadesShouldBeSpades() {
        Card card = Card.of(Rank.ACE, Suit.SPADES);
        assertEquals(Suit.SPADES, card.suit());
    }

    @Test
    public void threeOfHeartsShouldBeThree() {
        Card card = Card.of(Rank.THREE, Suit.HEARTS);
        assertEquals(Rank.THREE, card.rank());
    }

    @Test
    public void threeOfHeartsShouldBeHearts() {
        Card card = Card.of(Rank.THREE, Suit.HEARTS);
        assertEquals(Suit.HEARTS, card.suit());
    }

    @Test
    public void kingOfClubsShouldBeKing() {
        Card card = Card.of(Rank.KING, Suit.CLUBS);
        assertEquals(Rank.KING, card.rank());
    }

    @Test
    public void kingOfClubsShouldBeClubs() {
        Card card = Card.of(Rank.KING, Suit.CLUBS);
        assertEquals(Suit.CLUBS, card.suit());
    }

    @Test
    public void jackOfDiamondsShouldBeJack() {
        Card card = Card.of(Rank.JACK, Suit.DIAMONDS);
        assertEquals(Rank.JACK, card.rank());
    }

    @Test
    public void jackOfDiamondsShouldBeDiamonds() {
        Card card = Card.of(Rank.JACK, Suit.DIAMONDS);
        assertEquals(Suit.DIAMONDS, card.suit());
    }

}