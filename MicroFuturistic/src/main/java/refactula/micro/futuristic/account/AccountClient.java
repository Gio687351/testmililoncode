package refactula.micro.futuristic.account;

import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.NetworkClient;

public class AccountClient extends NetworkClient implements AccountService {
    private final AccountService delegate;

    public AccountClient(int minDelay, int maxDelay, AccountService delegate) {
        super(minDelay, maxDelay);
        this.delegate = delegate;
    }

    @Override
    public Token register(Username username) {
        return overNetwork(() -> delegate.register(username));
    }

    @Override
    public void authenticate(Username username, Token token) {
        overNetwork(() -> delegate.authenticate(username, token));
    }
}
