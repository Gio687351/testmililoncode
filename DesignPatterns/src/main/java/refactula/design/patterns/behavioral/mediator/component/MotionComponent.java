package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.World;

public class MotionComponent extends CreatureComponent {
    private float velocityX;
    private float velocityY;

    public void setVelocity(float x, float y) {
        velocityX = x;
        velocityY = y;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void update(float deltaTime) {
        World world = mediator().getWorld();
        mediator().move(world.restrictX(velocityX * deltaTime), world.restrictY(velocityY * deltaTime));
    }
}
