package refactula.design.patterns.behavioral.visitor.banking;

public interface CardVisitor {

    void visit(SavingCard savingCard);

    void visit(CreditCard creditCard);

}
