package refactula.design.patterns.object_pool.immutable;

import org.junit.Test;

import static org.junit.Assert.*;
import static refactula.design.patterns.object_pool.immutable.CardPool.card;
import static refactula.design.patterns.object_pool.immutable.Rank.*;
import static refactula.design.patterns.object_pool.immutable.Suit.*;

public class CardPoolTest {

    @Test
    public void testAceOfSpades() {
        Card card = card(ACE, SPADE);
        assertEquals(ACE, card.rank());
        assertEquals(SPADE, card.suit());
    }

    @Test
    public void testSevenOfHearts() {
        Card card = card(SEVEN, HEART);
        assertEquals(SEVEN, card.rank());
        assertEquals(HEART, card.suit());
    }

    @Test
    public void testQueenOfDiamonds() {
        Card card = card(QUEEN, DIAMOND);
        assertEquals(QUEEN, card.rank());
        assertEquals(DIAMOND, card.suit());
    }

    @Test
    public void testSameInstance() {
        assertSame(card(THREE, CLUB), card(THREE, CLUB));
    }

}