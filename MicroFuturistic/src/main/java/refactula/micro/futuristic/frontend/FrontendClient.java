package refactula.micro.futuristic.frontend;

import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.NetworkClient;

public class FrontendClient extends NetworkClient implements FrontendService {
    private final FrontendService delegate;

    public FrontendClient(int minDelay, int maxDelay, FrontendService delegate) {
        super(minDelay, maxDelay);
        this.delegate = delegate;
    }

    @Override
    public Token register(Username username, Email email) {
        return overNetwork(() -> delegate.register(username, email));
    }

    @Override
    public void setBillingDetails(Username username, Token token, BillingDetails billingDetails) {
        overNetwork(() -> delegate.setBillingDetails(username, token, billingDetails));
    }

    @Override
    public void deposit(Username username, Token token, Credits credits) {
        overNetwork(() -> delegate.deposit(username, token, credits));
    }

    @Override
    public void transfer(Username sender, Token senderToken, Username receiver, Credits credits) {
        overNetwork(() -> delegate.transfer(sender, senderToken, receiver, credits));
    }
}
