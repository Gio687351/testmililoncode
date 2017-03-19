package refactula.micro.futuristic.account;

import com.google.common.base.Preconditions;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AccountServer implements AccountService {
    private final ConcurrentMap<Username, Token> tokenMap = new ConcurrentHashMap<>();
    private final ConcurrentMap<Token, Username> usernameMap = new ConcurrentHashMap<>();

    @Override
    public Token register(Username username) {
        Preconditions.checkState(!tokenMap.containsKey(username));
        Token token = Token.geterate();
        Token existingToken = tokenMap.putIfAbsent(username, token);
        Preconditions.checkState(existingToken == null);
        Username existingUsername = usernameMap.putIfAbsent(token, username);
        Preconditions.checkState(existingUsername == null);
        return token;
    }

    @Override
    public void authenticate(Username username, Token token) {
        Token existingToken = tokenMap.get(username);
        Preconditions.checkArgument(token.equals(existingToken));
    }
}
