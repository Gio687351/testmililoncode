package refactula.onion_architecture.banking;

import refactula.onion_architecture.functional.Monad;

import java.util.List;

public interface MonadBanking extends Banking {
    @Override
    Monad<List<Account>> accounts();

    @Override
    Monad<Amount> balance(Account account);

    @Override
    Monad<TransferResult> transfer(Amount amount, From<Account> from, To<Account> to);

    @Override
    Monad<Amount> withdraw(Amount amount);
}
