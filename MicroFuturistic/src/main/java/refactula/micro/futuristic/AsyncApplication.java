package refactula.micro.futuristic;

import refactula.micro.futuristic.account.AccountClientF;
import refactula.micro.futuristic.account.AccountServer;
import refactula.micro.futuristic.account.AccountServiceF;
import refactula.micro.futuristic.billing.BillingClientF;
import refactula.micro.futuristic.billing.BillingServer;
import refactula.micro.futuristic.billing.BillingServiceF;
import refactula.micro.futuristic.email.EmailClientF;
import refactula.micro.futuristic.email.EmailServer;
import refactula.micro.futuristic.email.EmailServiceF;
import refactula.micro.futuristic.frontend.FrontendClientF;
import refactula.micro.futuristic.frontend.FrontendServerF;
import refactula.micro.futuristic.model.BillingDetails;
import refactula.micro.futuristic.model.CVCode;
import refactula.micro.futuristic.model.CreditCardNumber;
import refactula.micro.futuristic.model.Email;
import refactula.micro.futuristic.model.Username;
import refactula.micro.futuristic.utils.Logger;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.function.Supplier;

public class AsyncApplication {

    public static void main(String[] args) {
        Random random = new Random(573042751);
        Logger logger = System.out::println;
        // Logger logger = message -> {};

        int usersAmount = 100;
        int messagesAmount = 1000;
        int minNetworkDelay = 1;
        int maxNetworkDelay = 10;

        ScheduledExecutorService accountExecutor = Executors.newScheduledThreadPool(4);
        AccountServer accountServer = new AccountServer();
        AccountServiceF accountService = new AccountClientF(accountExecutor, minNetworkDelay, maxNetworkDelay, logger, accountServer);

        ScheduledExecutorService billingExecutor = Executors.newScheduledThreadPool(4);
        BillingServer billingServer = new BillingServer();
        BillingServiceF billingService = new BillingClientF(billingExecutor, minNetworkDelay, maxNetworkDelay, logger, billingServer);

        ScheduledExecutorService emailExecutor = Executors.newScheduledThreadPool(4);
        EmailServer emailServer = new EmailServer(logger);
        EmailServiceF emailService = new EmailClientF(emailExecutor, minNetworkDelay, maxNetworkDelay, logger, emailServer);

        ScheduledExecutorService frontendExecutor = Executors.newScheduledThreadPool(4);
        FrontendServerF frontendServer = new FrontendServerF(accountService, billingService, emailService);
        FrontendClientF frontendClient = new FrontendClientF(frontendExecutor, minNetworkDelay, maxNetworkDelay, logger, frontendServer);

        Supplier<Username> usernameSupplier = indexedGenerator(i -> new Username("User #" + i));
        Supplier<Email> emailSupplier = indexedGenerator(i -> new Email("email" + i + "@mail.com"));
        Supplier<BillingDetails> billingDetailsSupplier = indexedGenerator(i -> new BillingDetails(
                new CreditCardNumber(String.valueOf(i)),
                new CVCode(String.valueOf(i))));

        LoadTestF loadTest = new LoadTestF(
                random,
                usersAmount,
                messagesAmount,
                frontendClient,
                usernameSupplier,
                emailSupplier,
                billingDetailsSupplier);

        long startAt = System.currentTimeMillis();
        loadTest.run();
        long finishAt = System.currentTimeMillis();

        System.out.println("Sent " + messagesAmount + " messages in " + (finishAt - startAt) + " ms");
        System.exit(0);
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
