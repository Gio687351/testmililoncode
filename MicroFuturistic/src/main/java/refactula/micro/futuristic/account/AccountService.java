package refactula.micro.futuristic.account;

import refactula.micro.futuristic.Microservice;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;

public interface AccountService extends Microservice {
    Token register(Username username);
    void authenticate(Username username, Token token);
}
