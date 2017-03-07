package refactula.design.patterns.behavioral.mediator.component;

import com.google.common.base.Preconditions;
import refactula.design.patterns.behavioral.mediator.Creature;
import refactula.design.patterns.behavioral.mediator.Geometry;
import refactula.design.patterns.behavioral.mediator.shape.Circle;
import refactula.design.patterns.behavioral.mediator.shape.Shape;

public class CollisionComponent extends CreatureComponent {

    public void update() {
        for (Creature creature : mediator().getWorld().getCreatures()) {
            if (creature.isAlive() && collidesWith(creature)) {
                mediator().onCollide(creature);
                if (!mediator().isActive()) {
                    break;
                }
            }
        }
    }

    private boolean collidesWith(Creature other) {
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
        return Geometry.distanceSquared(myX, myY, otherX, otherY) < collisionDistance * collisionDistance;
    }

}
