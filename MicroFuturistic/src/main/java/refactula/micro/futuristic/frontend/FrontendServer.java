package refactula.micro.futuristic.frontend;

import refactula.micro.futuristic.account.AccountService;
import refactula.micro.futuristic.billing.BillingService;
import refactula.micro.futuristic.email.EmailService;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;

public class FrontendServer implements FrontendService {
    private final AccountService accountService;
    private final BillingService billingService;
    private final EmailService emailService;

    public FrontendServer(AccountService accountService, BillingService billingService, EmailService emailService) {
        this.accountService = accountService;
        this.billingService = billingService;
        this.emailService = emailService;
    }

    @Override
    public Token register(Username username, Email email) {
        Token token = accountService.register(username);
        emailService.setEmail(username, email);
        return token;
    }

    @Override
    public void setBillingDetails(Username username, Token token, BillingDetails billingDetails) {
        accountService.authenticate(username, token);
        billingService.setBillingDetails(username, billingDetails);
    }

    @Override
    public void deposit(Username username, Token token, Credits credits) {
        accountService.authenticate(username, token);
        billingService.deposit(username, credits);
        emailService.notify(username, "Deposited: " + credits);
    }

    @Override
    public void transfer(Username sender, Token senderToken, Username receiver, Credits credits) {
        accountService.authenticate(sender, senderToken);
        billingService.transfer(sender, receiver, credits);
        emailService.notify(sender, "Transferred " + credits + " to " + receiver);
        emailService.notify(receiver, "Received " + credits + " from " + sender);
    }
}
