package refactula.design.patterns.structural.flyweight;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import refactula.design.patterns.structural.flyweight.card.Card;
import refactula.design.patterns.structural.flyweight.hand.ClosedHand;
import refactula.design.patterns.structural.flyweight.hand.OpenHand;
import refactula.design.patterns.structural.flyweight.poker.PlayerPerspective;
import refactula.design.patterns.structural.flyweight.poker.PokerTable;

import static com.google.common.base.Preconditions.checkState;
import static refactula.design.patterns.structural.flyweight.card.Cards.*;

public class ExampleApp {

    public static void main(String[] args) {
        ImmutableList<Card> boardCards = ImmutableList.of(
                TEN_OF_CLUBS,
                ACE_OF_DIAMONDS,
                QUEEN_OF_CLUBS,
                ACE_OF_CLUBS,
                SEVEN_OF_SPADES);

        // Alice has Four of Aces.
        OpenHand aliceHand = OpenHand.of(ACE_OF_HEARTS, ACE_OF_SPADES);

        // Unfortunately for Alice, Bob has a Straight Flush.
        OpenHand bobHand = OpenHand.of(JACK_OF_CLUBS, KING_OF_CLUBS);

        PokerTable pokerTable = new PokerTable(boardCards, ImmutableMap.of(
                "Alice", aliceHand,
                "Bob", bobHand));

        PlayerPerspective alicePerspective = pokerTable.perspectiveOf("Alice");
        PlayerPerspective bobPerspective = pokerTable.perspectiveOf("Bob");

        // Both can see board cards.
        checkState(alicePerspective.getBoardCards().equals(boardCards));
        checkState(bobPerspective.getBoardCards().equals(boardCards));

        // Alice can see only her hand.
        checkState(alicePerspective.getPlayerHand("Alice").equals(aliceHand));
        checkState(alicePerspective.getPlayerHand("Bob").equals(ClosedHand.ofSize(2)));

        // Bob can see only his hand.
        checkState(bobPerspective.getPlayerHand("Alice").equals(ClosedHand.ofSize(2)));
        checkState(bobPerspective.getPlayerHand("Bob").equals(bobHand));
    }

}
