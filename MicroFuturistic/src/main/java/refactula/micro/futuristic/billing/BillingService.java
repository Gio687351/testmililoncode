package refactula.micro.futuristic.billing;

import refactula.micro.futuristic.Microservice;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Username;

public interface BillingService extends Microservice {
    void transfer(Username sender, Username receiver, Credits credits);
    void setBillingDetails(Username username, BillingDetails billingDetails);
    void deposit(Username username, Credits credits);
}
