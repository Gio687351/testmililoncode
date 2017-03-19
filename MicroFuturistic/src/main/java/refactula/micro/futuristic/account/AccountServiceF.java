package refactula.micro.futuristic.account;

import refactula.micro.futuristic.Microservice;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;

public interface AccountServiceF extends Microservice {
    Future<Token> register(Username username);
    Future<Void> authenticate(Username username, Token token);
}
