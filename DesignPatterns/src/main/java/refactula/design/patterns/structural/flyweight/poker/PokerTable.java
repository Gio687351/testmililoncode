package refactula.design.patterns.structural.flyweight.poker;

import refactula.design.patterns.structural.flyweight.card.Card;
import refactula.design.patterns.structural.flyweight.hand.Hand;
import refactula.design.patterns.structural.flyweight.hand.OpenHand;

import java.util.List;
import java.util.Map;

public class PokerTable {
    private final List<Card> boardCards;
    private final Map<String, OpenHand> playerHands;

    public PokerTable(List<Card> boardCards, Map<String, OpenHand> playerHands) {
        this.boardCards = boardCards;
        this.playerHands = playerHands;
    }

    public List<Card> getBoardCards() {
        return boardCards;
    }

    public Hand getPlayerHand(String name) {
        return playerHands.get(name);
    }

    public PlayerPerspective perspectiveOf(String name) {
        return new PlayerPerspective(name, this);
    }
}
