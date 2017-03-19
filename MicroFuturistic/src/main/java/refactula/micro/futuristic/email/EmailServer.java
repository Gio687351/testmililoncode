package refactula.micro.futuristic.email;

import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.google.common.base.Preconditions.checkNotNull;

public class EmailServer implements EmailService {
    private final ConcurrentMap<Username, Email> emailMap = new ConcurrentHashMap<>();
    private final Logger logger;

    public EmailServer(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void setEmail(Username username, Email email) {
        emailMap.put(username, email);
    }

    @Override
    public void notify(Username username, String message) {
        Email email = emailMap.get(username);
        checkNotNull(email);
        logger.println("Sending email to " + email + ": " + message);
    }
}
