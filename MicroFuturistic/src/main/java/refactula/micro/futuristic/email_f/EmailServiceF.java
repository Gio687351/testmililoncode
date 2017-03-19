package refactula.micro.futuristic.email_f;

import refactula.micro.futuristic.Microservice;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Future;

public interface EmailServiceF extends Microservice {
    Future<Void> setEmail(Username username, Email email);
    Future<Void> notify(Username username, String message);
}
