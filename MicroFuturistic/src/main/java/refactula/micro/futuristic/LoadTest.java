package refactula.micro.futuristic;

import com.google.common.util.concurrent.MoreExecutors;
import refactula.micro.futuristic.frontend.FrontendService;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.Credits;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Token;
import refactula.micro.futuristic.model.Username;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LoadTest {
    private final Random random;
    private final int usersAmount;
    private final int messagesAmount;
    private final FrontendService frontend;
    private final ExecutorService executorService;
    private final Supplier<Username> usernameSupplier;
    private final Supplier<Email> emailSupplier;
    private final Supplier<BillingDetails> billingDetailsSupplier;

    public LoadTest(
            Random random,
            int usersAmount,
            int messagesAmount,
            FrontendService frontend,
            ExecutorService executorService,
            Supplier<Username> usernameSupplier,
            Supplier<Email> emailSupplier,
            Supplier<BillingDetails> billingDetailsSupplier) {

        this.random = random;
        this.usersAmount = usersAmount;
        this.messagesAmount = messagesAmount;
        this.frontend = frontend;
        this.executorService = executorService;
        this.usernameSupplier = usernameSupplier;
        this.emailSupplier = emailSupplier;
        this.billingDetailsSupplier = billingDetailsSupplier;
    }

    public void run() {
        Queue<Runnable> commandsQueue = new LinkedList<>();
        ConcurrentMap<Username, Token> tokens = new ConcurrentHashMap<>();
        List<Username> users = new ArrayList<>();
        for (int i = 0; i < usersAmount; i++) {
            Username username = usernameSupplier.get();
            Email email = emailSupplier.get();
            users.add(username);
            Token token = frontend.register(username, email);
            tokens.put(username, token);
            frontend.setBillingDetails(username, token, billingDetailsSupplier.get());
            frontend.deposit(username, token, Credits.withAmount(messagesAmount));
        }
        for (int i = 0; i < messagesAmount; i++) {
            Username sender = users.get(random.nextInt(users.size()));
            Username receiver = users.get(random.nextInt(users.size()));
            commandsQueue.add(() -> {
                frontend.transfer(sender, tokens.get(sender), receiver, Credits.withAmount(1));
            });
        }
        for (Runnable command : commandsQueue) {
            executorService.execute(command);
        }
        while (!MoreExecutors.shutdownAndAwaitTermination(executorService, 1, TimeUnit.MINUTES)) {
            // Wait more
        }
    }
}
