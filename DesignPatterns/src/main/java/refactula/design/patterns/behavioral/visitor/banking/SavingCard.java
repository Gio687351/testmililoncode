package refactula.design.patterns.behavioral.visitor.banking;

public class SavingCard implements CardVisitable {
    private final String number;
    private final int amount;
    private final double interestRate;

    public SavingCard(String number, int amount, double interestRate) {
        this.number = number;
        this.amount = amount;
        this.interestRate = interestRate;
    }

    public String getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void visit(CardVisitor visitor) {
        visitor.visit(this);
    }
}
