package refactula.design.patterns.behavioral.visitor.banking;

public class CreditCard implements CardVisitable {
    private final String number;
    private final int amount;
    private final int creditLimit;

    public CreditCard(String number, int amount, int creditLimit) {
        this.number = number;
        this.amount = amount;
        this.creditLimit = creditLimit;
    }

    public String getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void visit(CardVisitor visitor) {
        visitor.visit(this);
    }
}
