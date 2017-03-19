package refactula.micro.futuristic.email;

import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.NetworkClient;

public class EmailClient extends NetworkClient implements EmailService {
    private final EmailService delegate;

    public EmailClient(int minDelay, int maxDelay, EmailService delegate) {
        super(minDelay, maxDelay);
        this.delegate = delegate;
    }

    @Override
    public void setEmail(Username username, Email email) {
        overNetwork(() -> delegate.setEmail(username, email));
    }

    @Override
    public void notify(Username username, String message) {
        overNetwork(() -> delegate.notify(username, message));
    }
}
