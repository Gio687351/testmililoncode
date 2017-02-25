package refactula.onion_architecture.banking.ads;

import refactula.onion_architecture.banking.Account;
import refactula.onion_architecture.banking.Amount;
import refactula.onion_architecture.banking.From;
import refactula.onion_architecture.banking.To;
import refactula.onion_architecture.banking.TransferResult;

import java.util.function.Function;

public final class Transfer<X> implements BankingF<X> {
    private final Amount amount;
    private final From<Account> from;
    private final To<Account> to;
    private final Function<TransferResult, X> next;

    public Transfer(Amount amount, From<Account> from, To<Account> to, Function<TransferResult, X> next) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.next = next;
    }

    public Amount getAmount() {
        return amount;
    }

    public From<Account> getFrom() {
        return from;
    }

    public To<Account> getTo() {
        return to;
    }

    public Function<TransferResult, X> getNext() {
        return next;
    }
}
