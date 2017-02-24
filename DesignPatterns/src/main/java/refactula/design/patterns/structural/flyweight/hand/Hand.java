package refactula.design.patterns.structural.flyweight.hand;

import refactula.design.patterns.structural.flyweight.utils.Openable;
import refactula.design.patterns.structural.flyweight.card.Card;

public interface Hand {

    int size();

    Openable<Card> getCard(int index);

    Hand closed();

}
