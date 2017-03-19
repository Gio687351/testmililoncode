package refactula.micro.futuristic.frontend;

import refactula.micro.futuristic.Microservice;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;

public interface FrontendService extends Microservice {

    Token register(Username username, Email email);

    void setBillingDetails(Username username, Token token, BillingDetails billingDetails);

    void deposit(Username username, Token token, Credits credits);

    void transfer(Username sender, Token senderToken, Username receiver, Credits credits);

}
