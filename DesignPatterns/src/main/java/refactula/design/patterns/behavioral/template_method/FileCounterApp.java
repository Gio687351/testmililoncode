package refactula.design.patterns.behavioral.template_method;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileCounterApp {

    public static void main(String[] args) {
        FileCounter fileCounter = new FileCounter(new File("lock"), new File("amount"));
        int nThreads = 16;
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; i++) {
            executor.execute(() -> {
                while (true) {
                    fileCounter.run();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    private static final class FileCounter extends LockedFileOperation {
        private final File file;

        private FileCounter(File lock, File file) {
            super(lock);
            this.file = file;
        }

        @Override
        protected void runUnderLock() {
            try {
                int number;
                if (file.exists()) {
                    number = Integer.parseInt(Files.readFirstLine(file, StandardCharsets.UTF_8));
                } else {
                    number = 0;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                int newNumber = number + 1;
                System.out.println("Writing: " + newNumber);
                Files.write(String.valueOf(newNumber), file, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }

}
