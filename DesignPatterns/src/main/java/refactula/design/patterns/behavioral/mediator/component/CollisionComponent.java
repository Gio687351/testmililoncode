package refactula.design.patterns.behavioral.mediator.component;

import com.google.common.base.Preconditions;
import refactula.design.patterns.behavioral.mediator.Creature;
import refactula.design.patterns.behavioral.mediator.shape.Circle;
import refactula.design.patterns.behavioral.mediator.shape.Shape;

public class CollisionComponent extends CreatureComponent {

    public boolean collidesWith(Creature other) {
        Shape myShape = mediator().getShape();
        float myX = mediator().getX();
        float myY = mediator().getY();

        Shape otherShape = other.getShape();
        float otherX = other.getX();
        float otherY = other.getY();

        Preconditions.checkState(myShape instanceof Circle && otherShape instanceof Circle);

        Circle myCircle = (Circle) myShape;
        Circle otherCircle = (Circle) otherShape;

        float myRadius = myCircle.getRadius();
        float otherRadius = otherCircle.getRadius();

        float collisionDistance = myRadius + otherRadius;
        return distanceSquared(myX, myY, otherX, otherY) < collisionDistance * collisionDistance;
    }

    private float distanceSquared(float x1, float y1, float x2, float y2) {
        float dx = x1 - x2;
        float dy = y1 - y2;
        return dx * dx + dy * dy;
    }

}
