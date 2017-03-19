package refactula.micro.futuristic;

import refactula.micro.futuristic.account.AccountClient;
import refactula.micro.futuristic.account.AccountServer;
import refactula.micro.futuristic.billing.BillingClient;
import refactula.micro.futuristic.billing.BillingServer;
import refactula.micro.futuristic.billing.BillingService;
import refactula.micro.futuristic.email.EmailClient;
import refactula.micro.futuristic.email.EmailServer;
import refactula.micro.futuristic.email.EmailService;
import refactula.micro.futuristic.frontend.FrontendClient;
import refactula.micro.futuristic.frontend.FrontendServer;
import refactula.micro.futuristic.frontend.FrontendService;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.CVCode;
import refactula.micro.futuristic.model.CreditCardNumber;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Username;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class SyncApplication {

    public static void main(String[] args) {
        Random random = new Random();

        int usersAmount = 100;
        int messagesAmount = 1000000;
        int minNetworkDelay = 10;
        int maxNetworkDelay = 100;
        int executorThreads = 16;

        AccountServer accountServer = new AccountServer();
        AccountClient accountService = new AccountClient(minNetworkDelay, maxNetworkDelay, accountServer);

        BillingServer billingServer = new BillingServer();
        BillingService billingService = new BillingClient(minNetworkDelay, maxNetworkDelay, billingServer);

        EmailServer emailServer = new EmailServer();
        EmailService emailService = new EmailClient(minNetworkDelay, maxNetworkDelay, emailServer);

        FrontendServer frontendServer = new FrontendServer(accountService, billingService, emailService);
        FrontendService frontendService = new FrontendClient(minNetworkDelay, maxNetworkDelay, frontendServer);
        ExecutorService executorService = Executors.newFixedThreadPool(executorThreads);

        Supplier<Username> usernameSupplier = indexedGenerator(i -> new Username("User #" + i));
        Supplier<Email> emailSupplier = indexedGenerator(i -> new Email("email" + i + "@mail.com"));
        Supplier<BillingDetails> billingDetailsSupplier = indexedGenerator(i -> new BillingDetails(
                new CreditCardNumber(String.valueOf(i)),
                new CVCode(String.valueOf(i))));

        LoadTest loadTest = new LoadTest(
                random,
                usersAmount,
                messagesAmount,
                frontendService,
                executorService,
                usernameSupplier,
                emailSupplier,
                billingDetailsSupplier);

        loadTest.run();
    }

    private static <T> Supplier<T> indexedGenerator(Function<Integer, T> indexFunction) {
        return new Supplier<T>() {
            private int index = 0;

            @Override
            public T get() {
                return indexFunction.apply(index++);
            }
        };
    }
}
