package refactula.micro.futuristic.frontend_f;

import refactula.micro.futuristic.account_f.AccountServiceF;
import refactula.micro.futuristic.billing_f.BillingServiceF;
import refactula.micro.futuristic.email_f.EmailServiceF;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;

public class FrontendServerF implements FrontendServiceF {
    private final AccountServiceF accountService;
    private final BillingServiceF billingService;
    private final EmailServiceF emailService;

    public FrontendServerF(AccountServiceF accountService, BillingServiceF billingService, EmailServiceF emailService) {
        this.accountService = accountService;
        this.billingService = billingService;
        this.emailService = emailService;
    }

    @Override
    public Future<Token> register(Username username, Email email) {
        return
            accountService.register(username) .flatMap(token ->
            emailService.setEmail(username, email) .map(nothing ->
            token));
    }

    @Override
    public Future<Void> setBillingDetails(Username username, Token token, BillingDetails billingDetails) {
        return
            accountService.authenticate(username, token) .flatMap(authenticated ->
            billingService.setBillingDetails(username, billingDetails));
    }

    @Override
    public Future<Void> deposit(Username username, Token token, Credits credits) {
        return
            accountService.authenticate(username, token) .flatMap(authenticated ->
            billingService.deposit(username, credits) .flatMap(deposited ->
            emailService.notify(username, "Deposited: " + credits)));
    }

    @Override
    public Future<Void> transfer(Username sender, Token senderToken, Username receiver, Credits credits) {
        return
            accountService.authenticate(sender, senderToken) .flatMap(authenticated ->
            billingService.transfer(sender, receiver, credits) .flatMap(transferred ->
            emailService.notify(sender, "Transferred " + credits + " to " + receiver) .map2(
            emailService.notify(receiver, "Received " + credits + " from " + sender), (senderNotified, receiverNotified) ->
            null)));
    }
}
