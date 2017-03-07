package refactula.design.patterns.behavioral.mediator.component;

import com.google.common.base.Preconditions;

public class PositionComponent extends CreatureComponent {
    private float x;
    private float y;

    public void setPosition(float x, float y) {
        Preconditions.checkArgument(mediator().getWorld().isInsideBounds(x, y));
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }
}
