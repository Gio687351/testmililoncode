package refactula.design.patterns.behavioral.mediator;

import refactula.design.patterns.behavioral.mediator.shape.Shape;

public class Creature {
    private final CreatureMediator creatureMediator;

    public Creature(CreatureMediator creatureMediator) {
        this.creatureMediator = creatureMediator;
    }

    public void onAdded(World world) {
        creatureMediator.onAdded(world);
    }

    public void onRemoved(World world) {
        creatureMediator.onRemoved(world);
    }

    public float getX() {
        return creatureMediator.getX();
    }

    public float getY() {
        return creatureMediator.getY();
    }

    public Shape getShape() {
        return creatureMediator.getShape();
    }

    public float getVelocityX() {
        return creatureMediator.getVelocityX();
    }

    public float getVelocityY() {
        return creatureMediator.getVelocityY();
    }
}
