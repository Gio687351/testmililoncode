package refactula.onion_architecture;

import refactula.onion_architecture.banking.Account;
import refactula.onion_architecture.banking.Amount;
import refactula.onion_architecture.banking.From;
import refactula.onion_architecture.banking.MonadBanking;
import refactula.onion_architecture.banking.To;
import refactula.onion_architecture.functional.Monad;

public class Program {

    public static Monad<Amount> program(MonadBanking F) {
        return F.accounts().flatMap(
                as -> F.balance(as.get(0)).flatMap(
                b -> F.transfer(amount(123), from(account("Foo")), to(account("Bar"))).flatMap(
                x -> F.withdraw(amount(5)).map(
                w -> b))));
    }

    private static <T> To<T> to(T obj) {
        return new To<>(obj);
    }

    private static <T> From<T> from(T obj) {
        return new From<>(obj);
    }

    private static Account account(String foo) {
        return new Account(foo);
    }

    private static Amount amount(int cents) {
        return new Amount(cents);
    }

}
