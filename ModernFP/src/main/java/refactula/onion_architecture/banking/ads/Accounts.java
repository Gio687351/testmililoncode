package refactula.onion_architecture.banking.ads;

import refactula.onion_architecture.banking.Account;

import java.util.List;
import java.util.function.Function;

public final class Accounts<X> implements BankingF<X> {
    private final Function<List<Account>, X> next;

    public Accounts(Function<List<Account>, X> next) {
        this.next = next;
    }

    public Function<List<Account>, X> getNext() {
        return next;
    }
}
