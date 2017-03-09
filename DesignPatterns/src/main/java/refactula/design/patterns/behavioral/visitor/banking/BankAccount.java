package refactula.design.patterns.behavioral.visitor.banking;

import java.util.List;

public class BankAccount implements CardVisitable {
    private final List<CardVisitable> cards;

    public BankAccount(List<CardVisitable> cards) {
        this.cards = cards;
    }

    @Override
    public void visit(CardVisitor visitor) {
        for (CardVisitable card : cards) {
            card.visit(visitor);
        }
    }
}
