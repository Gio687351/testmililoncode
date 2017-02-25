package refactula.onion_architecture.banking.adt;

import refactula.onion_architecture.banking.Account;
import refactula.onion_architecture.banking.Amount;
import refactula.onion_architecture.banking.Banking;
import refactula.onion_architecture.banking.From;
import refactula.onion_architecture.banking.To;
import refactula.onion_architecture.banking.TransferResult;

import java.util.List;
import java.util.function.Function;

public final class BankingFBanking implements Banking {
    @Override
    public BankingF<List<Account>> accounts() {
        return new Accounts<>(Function.identity());
    }

    @Override
    public BankingF<Amount> balance(Account account) {
        return new Balance<>(account, Function.identity());
    }

    @Override
    public BankingF<TransferResult> transfer(Amount amount, From<Account> from, To<Account> to) {
        return new Transfer<>(amount, from, to, Function.identity());
    }

    @Override
    public BankingF<Amount> withdraw(Amount amount) {
        return new Withdraw<>(amount, Function.identity());
    }
}
