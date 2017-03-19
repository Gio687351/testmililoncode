package refactula.micro.futuristic.billing_f;

import refactula.micro.futuristic.Microservice;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;

public interface BillingServiceF extends Microservice {
    Future<Void> transfer(Username sender, Username receiver, Credits credits);
    Future<Void> setBillingDetails(Username username, BillingDetails billingDetails);
    Future<Void> deposit(Username username, Credits credits);
}
