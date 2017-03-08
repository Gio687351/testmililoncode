package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.Geometry;

public class PositionComponent extends CreatureComponent {
    private float x;
    private float y;

    public void setPosition(float x, float y) {
        this.x = mediator().getWorld().restrictX(x);
        this.y = mediator().getWorld().restrictY(y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void movePosition(float dx, float dy) {
        setPosition(x + dx, y + dy);
    }

    public boolean isInsideCircle(float x, float y, float radius) {
        return Geometry.distanceSquared(x, y, getX(), getY()) <= radius * radius;
    }
}
