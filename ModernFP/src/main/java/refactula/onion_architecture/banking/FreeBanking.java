package refactula.onion_architecture.banking;

import refactula.onion_architecture.functional.free.Free;

import java.util.List;

public class FreeBanking implements Banking {
    private final Banking delegate;

    public FreeBanking(Banking delegate) {
        this.delegate = delegate;
    }

    @Override
    public Free<List<Account>> accounts() {
        return Free.liftF(delegate.accounts());
    }

    @Override
    public Free<Amount> balance(Account account) {
        return Free.liftF(delegate.balance(account));
    }

    @Override
    public Free<TransferResult> transfer(Amount amount, From<Account> from, To<Account> to) {
        return Free.liftF(delegate.transfer(amount, from, to));
    }

    @Override
    public Free<Amount> withdraw(Amount amount) {
        return Free.liftF(delegate.withdraw(amount));
    }
}
