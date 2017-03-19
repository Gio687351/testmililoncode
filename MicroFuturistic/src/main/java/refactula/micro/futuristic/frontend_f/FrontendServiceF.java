package refactula.micro.futuristic.frontend_f;

import refactula.micro.futuristic.Microservice;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;

public interface FrontendServiceF extends Microservice {
    Future<Token> register(Username username, Email email);
    Future<Void> setBillingDetails(Username username, Token token, BillingDetails billingDetails);
    Future<Void> deposit(Username username, Token token, Credits credits);
    Future<Void> transfer(Username sender, Token senderToken, Username receiver, Credits credits);
}
