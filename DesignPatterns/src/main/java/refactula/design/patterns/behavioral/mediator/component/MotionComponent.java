package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.Geometry;

public class MotionComponent extends CreatureComponent {
    private float velocityX;
    private float velocityY;

    public void limitAndSetVelocity(float x, float y, float maxVelocity) {
        float length = Geometry.length(x, y);
        setVelocity(x * maxVelocity / length, y * maxVelocity / length);
    }

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

    public void updateMotion(float deltaTime) {
        mediator().movePosition(velocityX * deltaTime, velocityY * deltaTime);
    }

    public void moveTowards(float x, float y, float maxVelocity) {
        limitAndSetVelocity(x - mediator().getX(), y - mediator().getY(), maxVelocity);
    }
}
