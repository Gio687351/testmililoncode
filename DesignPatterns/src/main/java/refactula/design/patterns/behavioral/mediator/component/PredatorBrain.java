package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.Creature;
import refactula.design.patterns.behavioral.mediator.FleshType;
import refactula.design.patterns.behavioral.mediator.World;

import java.util.Random;

public class PredatorBrain extends BrainComponent {
    private final float visibilityRadius;

    private final Wonder wonder;
    private final Hunt hunt;

    private Strategy activeStrategy;

    public PredatorBrain(
            Random random,
            float maxWonderVelocity,
            float maxHuntVelocity,
            float visibilityRadius) {

        this.visibilityRadius = visibilityRadius;
        this.wonder = new Wonder(random, maxWonderVelocity);
        this.hunt = new Hunt(maxHuntVelocity);
        this.activeStrategy = wonder;
    }

    @Override
    public void updateBrain() {
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
        private final Random random;

        private Wonder(Random random, float maxVelocity) {
            super(maxVelocity);
            this.random = random;
        }

        @Override
        public void update() {
            float randomVelocityX = (2 * random.nextFloat() - 1) * maxVelocity;
            float randomVelocityY = (2 * random.nextFloat() - 1) * maxVelocity;
            float newVelocityX = mediator().getVelocityX() * 0.9f + randomVelocityX * 0.1f;
            float newVelocityY = mediator().getVelocityY() * 0.9f + randomVelocityY * 0.1f;
            mediator().limitAndSetVelocity(newVelocityX, newVelocityY, maxVelocity);
            if (random.nextInt(10) == 0) {
                World world = mediator().getWorld();
                float x = mediator().getX();
                float y = mediator().getY();
                for (Creature creature : world.getCreaturesInRadius(x, y, visibilityRadius)) {
                    if (creature.getFleshType() == FleshType.RICH_MEAT) {
                        hunt.target = creature;
                        activeStrategy = hunt;
                        return;
                    }
                }
            }
        }
    }

    private class Hunt extends Strategy {
        private Creature target;

        private Hunt(float maxVelocity) {
            super(maxVelocity);
        }

        @Override
        public void update() {
            if (target == null || !target.isAlive() || hasLostTheTarget()) {
                target = null;
                activeStrategy = wonder;
            } else {
                float dx = target.getX() - mediator().getX();
                float dy = target.getY() - mediator().getY();
                mediator().limitAndSetVelocity(dx, dy, maxVelocity);
            }
        }

        private boolean hasLostTheTarget() {
            return !target.isInsideCircle(mediator().getX(), mediator().getY(), visibilityRadius);
        }
    }
}
