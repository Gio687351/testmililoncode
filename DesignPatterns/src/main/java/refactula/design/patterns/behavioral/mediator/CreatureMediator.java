package refactula.design.patterns.behavioral.mediator;

import refactula.design.patterns.behavioral.mediator.component.*;
import refactula.design.patterns.behavioral.mediator.shape.Shape;

public class CreatureMediator {
    private final WorldComponent worldComponent;
    private final PositionComponent positionComponent;
    private final ShapeComponent shapeComponent;
    private final CollisionComponent collisionComponent;
    private final MotionComponent motionComponent;
    private final FleshComponent fleshComponent;
    private final BrainComponent brainComponent;
    private final StomachComponent stomachComponent;
    private final AlivenessComponent alivenessComponent;
    private final PainterComponent painterComponent;

    public CreatureMediator(
            WorldComponent worldComponent,
            PositionComponent positionComponent,
            ShapeComponent shapeComponent,
            CollisionComponent collisionComponent,
            MotionComponent motionComponent,
            FleshComponent fleshComponent,
            BrainComponent brainComponent,
            StomachComponent stomachComponent,
            AlivenessComponent alivenessComponent,
            PainterComponent painterComponent) {

        this.worldComponent = worldComponent;
        this.positionComponent = positionComponent;
        this.shapeComponent = shapeComponent;
        this.collisionComponent = collisionComponent;
        this.motionComponent = motionComponent;
        this.fleshComponent = fleshComponent;
        this.brainComponent = brainComponent;
        this.stomachComponent = stomachComponent;
        this.alivenessComponent = alivenessComponent;
        this.painterComponent = painterComponent;
        init();
    }

    private void init() {
        worldComponent.setMediator(this);
        positionComponent.setMediator(this);
        shapeComponent.setMediator(this);
        collisionComponent.setMediator(this);
        motionComponent.setMediator(this);
        fleshComponent.setMediator(this);
        brainComponent.setMediator(this);
        stomachComponent.setMediator(this);
        alivenessComponent.setMediator(this);
        painterComponent.setMediator(this);
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

    public void movePosition(float dx, float dy) {
        positionComponent.movePosition(dx, dy);
    }

    public boolean isInsideCircle(float x, float y, float radius) {
        return positionComponent.isInsideCircle(x, y, radius);
    }

    public Shape getShape() {
        return shapeComponent.getShape();
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

    public void updateMotion(float deltaTime) {
        motionComponent.updateMotion(deltaTime);
    }

    public void moveTowards(float x, float y, float maxVelocity) {
        motionComponent.moveTowards(x, y, maxVelocity);
    }

    public void updateBrain() {
        brainComponent.updateBrain();
    }

    public void updateCollisions() {
        collisionComponent.updateCollisions();
    }

    public void limitAndSetVelocity(float x, float y, float maxVelocity) {
        motionComponent.limitAndSetVelocity(x, y, maxVelocity);
    }

    public boolean isActive() {
        return worldComponent.isActive();
    }

    public FleshType getFleshType() {
        return fleshComponent.getFleshType();
    }

    public void onCollide(Creature creature) {
        stomachComponent.onCollide(creature);
    }

    public void die() {
        alivenessComponent.die();
    }

    public boolean isAlive() {
        return alivenessComponent.isAlive();
    }

    public void draw(Painter painter) {
        painterComponent.draw(painter);
    }
}
