package refactula.design.patterns.structural.proxy;

import refactula.design.patterns.structural.proxy.property.BlockingAccessProperty;
import refactula.design.patterns.structural.proxy.property.FileLockingProperty;
import refactula.design.patterns.structural.proxy.property.FileLockingProperty.RetryListener;
import refactula.design.patterns.structural.proxy.property.PathProperty;
import refactula.design.patterns.structural.proxy.property.Property;
import refactula.design.patterns.structural.proxy.property.SerializableProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @see BlockingAccessProperty BlockingAccessProperty - a proxy that controls multi-threaded access to the resource
 * @see FileLockingProperty FileLockingProperty - a proxy that controls multi-process access to the resource
 */
public class ProxyApp {

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        RetryListener retryListener = () -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        };

        Path propertyPath = Files.createTempFile("property", ".txt");
        Path lockPath = Files.createTempFile("property", ".lock");
        Files.delete(propertyPath);
        Files.delete(lockPath);

        Runnable runnable = () -> {
            Property<Integer> property = new FileLockingProperty<>(
                    lockPath,
                    retryListener,
                    new SerializableProperty<>(new PathProperty(propertyPath)));

            int newValue = random.nextInt(100);
            property.update(old -> {
                System.out.println("Old value: " + old);
                System.out.println("New value: " + newValue);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                return newValue;
            });
        };

        int threads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

}
