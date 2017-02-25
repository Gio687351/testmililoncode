package refactula.onion_architecture.banking;

import refactula.onion_architecture.functional.Type;

import java.util.List;

public interface Banking {

    Type<List<Account>> accounts();

    Type<Amount> balance(Account account);

    Type<TransferResult> transfer(Amount amount, From<Account> from, To<Account> to);

    Type<Amount> withdraw(Amount amount);

}
