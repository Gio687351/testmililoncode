package refactula.micro.futuristic.billing_f;

import refactula.micro.futuristic.billing.BillingService;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;
import refactula.micro.futuristic.utils.Logger;
import refactula.micro.futuristic.utils.NetworkAdapterF;

import java.util.concurrent.ScheduledExecutorService;

public class BillingServerF extends NetworkAdapterF implements BillingServiceF {
    private final BillingService billingService;

    public BillingServerF(ScheduledExecutorService executorService, int minDelay, int maxDelay, Logger logger, BillingService billingService) {
        super(executorService, minDelay, maxDelay, logger);
        this.billingService = billingService;
    }

    @Override
    public Future<Void> transfer(Username sender, Username receiver, Credits credits) {
        return perform(() -> billingService.transfer(sender, receiver, credits));
    }

    @Override
    public Future<Void> setBillingDetails(Username username, BillingDetails billingDetails) {
        return perform(() -> billingService.setBillingDetails(username, billingDetails));
    }

    @Override
    public Future<Void> deposit(Username username, Credits credits) {
        return perform(() -> billingService.deposit(username, credits));
    }
}
