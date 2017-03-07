package refactula.design.patterns.behavioral.mediator;

import refactula.design.patterns.behavioral.mediator.component.CollisionComponent;
import refactula.design.patterns.behavioral.mediator.component.MotionComponent;
import refactula.design.patterns.behavioral.mediator.component.PositionComponent;
import refactula.design.patterns.behavioral.mediator.component.ShapeComponent;
import refactula.design.patterns.behavioral.mediator.component.WorldComponent;
import refactula.design.patterns.behavioral.mediator.shape.Shape;

public class CreatureMediator {
    private final WorldComponent worldComponent;
    private final PositionComponent positionComponent;
    private final ShapeComponent shapeComponent;
    private final CollisionComponent collisionComponent;
    private final MotionComponent motionComponent;

    public CreatureMediator(
            WorldComponent worldComponent,
            PositionComponent positionComponent,
            ShapeComponent shapeComponent,
            CollisionComponent collisionComponent,
            MotionComponent motionComponent) {

        this.worldComponent = worldComponent;
        this.positionComponent = positionComponent;
        this.shapeComponent = shapeComponent;
        this.collisionComponent = collisionComponent;
        this.motionComponent = motionComponent;
    }

    public void onAdded(World world) {
        worldComponent.onAdded(world);
    }

    public void onRemoved(World world) {
        worldComponent.onRemoved(world);
    }

    public World getWorld() {
        return worldComponent.getWorld();
    }

    public void setPosition(float x, float y) {
        positionComponent.setPosition(x, y);
    }

    public float getX() {
        return positionComponent.getX();
    }

    public float getY() {
        return positionComponent.getY();
    }

    public void move(float dx, float dy) {
        positionComponent.move(dx, dy);
    }

    public Shape getShape() {
        return shapeComponent.getShape();
    }

    public boolean collidesWith(Creature other) {
        return collisionComponent.collidesWith(other);
    }

    public void setVelocity(float x, float y) {
        motionComponent.setVelocity(x, y);
    }

    public float getVelocityX() {
        return motionComponent.getVelocityX();
    }

    public float getVelocityY() {
        return motionComponent.getVelocityY();
    }

    public void update(float deltaTime) {
        motionComponent.update(deltaTime);
    }
}
