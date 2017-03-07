package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.Creature;
import refactula.design.patterns.behavioral.mediator.FleshType;
import refactula.design.patterns.behavioral.mediator.World;

import java.util.Random;

public class HerbivoreBrain extends BrainComponent {
    private final Random random;
    private final Wonder wonder;
    private final float visibilityRadius;

    private final Eat eat;
    private final Escape escape;

    private Strategy activeStrategy;

    public HerbivoreBrain(
            Random random,
            float maxWonderVelocity,
            float maxEscapeVelocity,
            float visibilityRadius) {

        this.random = random;
        this.visibilityRadius = visibilityRadius;

        this.wonder = new Wonder(maxWonderVelocity);
        this.eat = new Eat(maxWonderVelocity);
        this.escape = new Escape(maxEscapeVelocity);
        this.activeStrategy = wonder;
    }

    @Override
    public void update() {
        activeStrategy.update();
    }

    private abstract class Strategy {
        protected final float maxVelocity;

        protected Strategy(float maxVelocity) {
            this.maxVelocity = maxVelocity;
        }

        public abstract void update();
    }

    private class Wonder extends Strategy {
        private Wonder(float maxVelocity) {
            super(maxVelocity);
        }

        @Override
        public void update() {
            float randomVelocityX = (2 * random.nextFloat() - 1) * maxVelocity;
            float randomVelocityY = (2 * random.nextFloat() - 1) * maxVelocity;
            float newVelocityX = mediator().getVelocityX() * 0.9f + randomVelocityX * 0.1f;
            float newVelocityY = mediator().getVelocityY() * 0.9f + randomVelocityY * 0.1f;
            mediator().limitAndSetVelocity(newVelocityX, newVelocityY, maxVelocity);

            World world = mediator().getWorld();
            float x = mediator().getX();
            float y = mediator().getY();
            for (Creature creature : world.getCreaturesInRadius(x, y, visibilityRadius)) {
                if (creature.getFleshType() == FleshType.LEAN_MEAT) {
                    escape.predator = creature;
                    activeStrategy = escape;
                    return;
                }
            }

            if (random.nextInt(10) == 0) {
                for (Creature creature : world.getCreaturesInRadius(x, y, visibilityRadius)) {
                    if (creature.getFleshType() == FleshType.PLANT) {
                        eat.target = creature;
                        activeStrategy = eat;
                        return;
                    }
                }
            }
        }
    }

    private class Eat extends Strategy {
        private Creature target;

        private Eat(float maxVelocity) {
            super(maxVelocity);
        }

        @Override
        public void update() {
            if (target == null || !target.isAlive() || hasLostTheTarget()) {
                target = null;
                activeStrategy = wonder;
            } else {
                mediator().moveTowards(target.getX(), target.getY(), maxVelocity);
            }
        }

        private boolean hasLostTheTarget() {
            return !target.isInsideCircle(mediator().getX(), mediator().getY(), visibilityRadius);
        }
    }

    private class Escape extends Strategy {
        private Creature predator;

        private Escape(float maxVelocity) {
            super(maxVelocity);
        }

        @Override
        public void update() {
            if (predator == null || !predator.isAlive() || hasLostThePredator()) {
                predator = null;
                activeStrategy = wonder;
            } else {
                mediator().limitAndSetVelocity(
                        mediator().getX() - predator.getX(),
                        mediator().getY() - predator.getY(),
                        maxVelocity);
            }
        }

        private boolean hasLostThePredator() {
            return !predator.isInsideCircle(mediator().getX(), mediator().getY(), visibilityRadius);
        }
    }
}
