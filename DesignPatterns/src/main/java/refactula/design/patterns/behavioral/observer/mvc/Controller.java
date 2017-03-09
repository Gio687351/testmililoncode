package refactula.design.patterns.behavioral.observer.mvc;

import refactula.design.patterns.behavioral.observer.Subscriptions;
import refactula.design.patterns.behavioral.observer.mvc.Model.Listener;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Controller {

    public static void main(String[] args) {
        new Controller().run();
    }

    private void run() {
        createFontMetrics();
        Random random = new Random();
        float width = 800;
        float height = 600;
        int circlesAmount = 200;
        float maxInitialRadius = 30f;
        float radiusGrowthSpeed = 40f;
        float maxRadius = 80f;
        float maxPhraseTime = 0.8f;
        View view = new View(random, width, height);
        Subscriptions<Listener> subscriptions = new Subscriptions<>();
        subscriptions.subscribe(view);
        Model model = new Model(
                subscriptions,
                random,
                width,
                height,
                circlesAmount,
                maxInitialRadius,
                radiusGrowthSpeed,
                maxRadius,
                maxPhraseTime);

        view.show();
        long last = System.currentTimeMillis();
        while (true) {
            long current = System.currentTimeMillis();
            model.update((current - last) / 1000f);
            last = current;
        }
    }

    private static void createFontMetrics() {
        new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY).createGraphics().getFontMetrics();
    }

}
