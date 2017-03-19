package refactula.micro.futuristic.billing;

import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.NetworkClient;

public class BillingClient extends NetworkClient implements BillingService {
    private final BillingService delegate;

    public BillingClient(int minDelay, int maxDelay, BillingService delegate) {
        super(minDelay, maxDelay);
        this.delegate = delegate;
    }

    @Override
    public void transfer(Username sender, Username receiver, Credits credits) {
        overNetwork(() -> delegate.transfer(sender, receiver, credits));
    }

    @Override
    public void setBillingDetails(Username username, BillingDetails billingDetails) {
        overNetwork(() -> delegate.setBillingDetails(username, billingDetails));
    }

    @Override
    public void deposit(Username username, Credits credits) {
        overNetwork(() -> delegate.deposit(username, credits));
    }
}
