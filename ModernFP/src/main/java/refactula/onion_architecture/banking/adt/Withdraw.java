package refactula.onion_architecture.banking.adt;

import refactula.onion_architecture.banking.Amount;

import java.util.function.Function;

public final class Withdraw<X> implements BankingF<X> {
    private final Amount amount;
    private final Function<Amount, X> next;

    public Withdraw(Amount amount, Function<Amount, X> next) {
        this.amount = amount;
        this.next = next;
    }

    public Amount getAmount() {
        return amount;
    }

    public Function<Amount, X> getNext() {
        return next;
    }
}
