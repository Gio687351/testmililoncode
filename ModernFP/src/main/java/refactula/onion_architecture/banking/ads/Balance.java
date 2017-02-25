package refactula.onion_architecture.banking.ads;

import refactula.onion_architecture.banking.Account;
import refactula.onion_architecture.banking.Amount;

import java.util.function.Function;

public final class Balance<X> implements BankingF<X> {
    private final Account account;
    private final Function<Amount, X> next;

    public Balance(Account account, Function<Amount, X> next) {
        this.account = account;
        this.next = next;
    }

    public Account getAccount() {
        return account;
    }

    public Function<Amount, X> getNext() {
        return next;
    }
}
