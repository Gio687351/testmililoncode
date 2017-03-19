package refactula.micro.futuristic.account_f;

import refactula.micro.futuristic.account.AccountService;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;
import refactula.micro.futuristic.utils.Logger;
import refactula.micro.futuristic.utils.NetworkAdapterF;

import java.util.concurrent.ScheduledExecutorService;

public class AccountClientF extends NetworkAdapterF implements AccountServiceF {
    private final AccountService accountService;

    public AccountClientF(ScheduledExecutorService executorService, int minDelay, int maxDelay, Logger logger, AccountService accountService) {
        super(executorService, minDelay, maxDelay, logger);
        this.accountService = accountService;
    }

    @Override
    public Future<Token> register(Username username) {
        return perform(() -> accountService.register(username));
    }

    @Override
    public Future<Void> authenticate(Username username, Token token) {
        return perform(() -> accountService.authenticate(username, token));
    }
}
