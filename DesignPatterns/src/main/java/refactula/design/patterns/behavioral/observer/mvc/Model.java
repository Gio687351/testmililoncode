package refactula.design.patterns.behavioral.observer.mvc;

import com.google.common.collect.ImmutableList;
import refactula.design.patterns.behavioral.observer.Subscriptions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Model {
    private static final List<String> MOTIVATIONAL_PHRASES = ImmutableList.of(
            "You are fine",
            "It feels good",
            "You can do it!",
            "You're great",
            "Breathe deeper",
            "Everything is possible",
            "Feels amazing",
            "So warm",
            "This is amazing",
            "You're right",
            "Relax",
            "How strong are you?",
            "happy or hilarious?"
    );

    private final Subscriptions<Listener> subscriptions;
    private final Random random;

    private final float width;
    private final float height;
    private final int circlesAmount;
    private final float maxInitialRadius;
    private final float radiusGrowthSpeed;
    private final float maxRadius;
    private final float maxPhraseTime;

    private final Set<Circle> circles = new HashSet<>();
    private float phraseTime;

    public Model(
            Subscriptions<Listener> subscriptions,
            Random random,
            float width,
            float height,
            int circlesAmount,
            float maxInitialRadius,
            float radiusGrowthSpeed,
            float maxRadius,
            float maxPhraseTime) {

        this.subscriptions = subscriptions;
        this.random = random;
        this.width = width;
        this.height = height;
        this.circlesAmount = circlesAmount;
        this.maxInitialRadius = maxInitialRadius;
        this.radiusGrowthSpeed = radiusGrowthSpeed;
        this.maxRadius = maxRadius;
        this.maxPhraseTime = maxPhraseTime;
        phraseTime = -maxPhraseTime * 5;
    }

    public void update(float deltaTime) {
        for (Iterator<Circle> iterator = circles.iterator(); iterator.hasNext(); ) {
            Circle circle = iterator.next();
            update(circle, deltaTime);
            if (circle.radius > maxRadius) {
                iterator.remove();
                subscriptions.notify(listener -> listener.onCircleRemoved(circle));
            }
        }
        addMissingCircles();
        phraseTime += deltaTime;
        if (phraseTime > maxPhraseTime) {
            String newPhrase = MOTIVATIONAL_PHRASES.get(random.nextInt(MOTIVATIONAL_PHRASES.size()));
            phraseTime = 0;
            subscriptions.notify(listener -> listener.onPhraseChanged(newPhrase));
        }
    }

    private void addMissingCircles() {
        while (circles.size() < circlesAmount) {
            Circle circle = new Circle();
            circle.x = random.nextFloat() * width;
            circle.y = random.nextFloat() * height;
            circle.radius = random.nextFloat() * maxInitialRadius;
            add(circle);
        }
    }

    private void add(Circle circle) {
        circles.add(circle);
        subscriptions.notify(listener -> listener.onCircleAdded(circle));
    }

    private void update(Circle circle, float deltaTime) {
        circle.radius += deltaTime * radiusGrowthSpeed;
        subscriptions.notify(listener -> listener.onCircleUpdated(circle));
    }

    private static class Circle implements ReadonlyCircle {
        private float x;
        private float y;
        private float radius;

        @Override
        public float getX() {
            return x;
        }

        @Override
        public float getY() {
            return y;
        }

        @Override
        public float getRadius() {
            return radius;
        }
    }

    public interface ReadonlyCircle {
        float getX();
        float getY();
        float getRadius();
    }

    public interface Listener {
        void onCircleAdded(ReadonlyCircle circle);
        void onCircleUpdated(ReadonlyCircle circle);
        void onCircleRemoved(ReadonlyCircle circle);
        void onPhraseChanged(String phrase);
    }
}
