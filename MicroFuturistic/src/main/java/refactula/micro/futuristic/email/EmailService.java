package refactula.micro.futuristic.email;

import refactula.micro.futuristic.Microservice;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Username;

public interface EmailService extends Microservice {
    void setEmail(Username username, Email email);
    void notify(Username username, String message);
}
