package refactula.design.patterns.structural.flyweight.poker;

import refactula.design.patterns.structural.flyweight.card.Card;
import refactula.design.patterns.structural.flyweight.hand.Hand;

import java.util.List;

/**
 * Is a flyweight that allows different player perspectives to share the same PokerTable instance.
 */
public class PlayerPerspective {
    private final String name;
    private final PokerTable pokerTable;

    public PlayerPerspective(String name, PokerTable pokerTable) {
        this.name = name;
        this.pokerTable = pokerTable;
    }

    public List<Card> getBoardCards() {
        return pokerTable.getBoardCards();
    }

    public Hand getPlayerHand(String name) {
        Hand hand = pokerTable.getPlayerHand(name);
        return this.name.equals(name) ? hand : hand.closed();
    }
}
