package refactula.micro.futuristic.frontend;

import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;
import refactula.micro.futuristic.utils.Logger;
import refactula.micro.futuristic.utils.NetworkClientF;

import java.util.concurrent.ScheduledExecutorService;

public class FrontendClientF extends NetworkClientF implements FrontendServiceF {
    private final FrontendServiceF frontendService;

    public FrontendClientF(ScheduledExecutorService executorService, int minDelay, int maxDelay, Logger logger, FrontendServiceF frontendService) {
        super(executorService, minDelay, maxDelay, logger);
        this.frontendService = frontendService;
    }

    @Override
    public Future<Token> register(Username username, Email email) {
        return perform(() -> frontendService.register(username, email));
    }

    @Override
    public Future<Void> setBillingDetails(Username username, Token token, BillingDetails billingDetails) {
        return perform(() -> frontendService.setBillingDetails(username, token, billingDetails));
    }

    @Override
    public Future<Void> deposit(Username username, Token token, Credits credits) {
        return perform(() -> frontendService.deposit(username, token, credits));
    }

    @Override
    public Future<Void> transfer(Username sender, Token senderToken, Username receiver, Credits credits) {
        return perform(() -> frontendService.transfer(sender, senderToken, receiver, credits));
    }
}
