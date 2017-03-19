package refactula.micro.futuristic.email_f;

import refactula.micro.futuristic.email.EmailService;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;
import refactula.micro.futuristic.utils.Logger;
import refactula.micro.futuristic.utils.NetworkAdapterF;

import java.util.concurrent.ScheduledExecutorService;

public class EmailClientF extends NetworkAdapterF implements EmailServiceF {
    private final EmailService emailService;

    public EmailClientF(ScheduledExecutorService executorService, int minDelay, int maxDelay, Logger logger, EmailService emailService) {
        super(executorService, minDelay, maxDelay, logger);
        this.emailService = emailService;
    }

    @Override
    public Future<Void> setEmail(Username username, Email email) {
        return perform(() -> emailService.setEmail(username, email));
    }

    @Override
    public Future<Void> notify(Username username, String message) {
        return perform(() -> emailService.notify(username, message));
    }
}
