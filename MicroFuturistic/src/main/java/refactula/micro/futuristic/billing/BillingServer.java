package refactula.micro.futuristic.billing;

import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Username;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class BillingServer implements BillingService {
    private final ConcurrentMap<Username, BillingDetails> detailsMap = new ConcurrentHashMap<>();
    private final ConcurrentMap<Username, Credits> creditsMap = new ConcurrentHashMap<>();

    @Override
    public void setBillingDetails(Username username, BillingDetails billingDetails) {
        detailsMap.put(username, billingDetails);
    }

    @Override
    public void deposit(Username username, Credits credits) {
        requireBillingDetails(username);
        creditsMap.compute(username, (name, existing) -> Credits.ofNullable(existing).plus(credits));
    }

    @Override
    public void transfer(Username sender, Username receiver, Credits credits) {
        requireBillingDetails(sender);
        requireBillingDetails(receiver);
        creditsMap.compute(sender, (username, senderCredits) -> Credits.ofNullable(senderCredits).minus(credits));
        creditsMap.compute(receiver, (username, receiverCredits) -> Credits.ofNullable(receiverCredits).plus(credits));
    }

    private BillingDetails requireBillingDetails(Username username) {
        return checkNotNull(detailsMap.get(username));
    }
}
