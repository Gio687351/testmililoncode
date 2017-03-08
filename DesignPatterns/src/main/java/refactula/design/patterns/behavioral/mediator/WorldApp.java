package refactula.design.patterns.behavioral.mediator;

import refactula.design.patterns.behavioral.mediator.component.*;
import refactula.design.patterns.behavioral.mediator.shape.Circle;

import java.util.Random;

public class WorldApp {

    public static void main(String[] args) {
        World world = new World(100f, 100f);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            createPlant(
                    world,
                    random.nextFloat() * world.getWidth(),
                    random.nextFloat() * world.getHeight());
        }
        for (int i = 0; i < 10; i++) {
            createHerbivore(
                    world,
                    random,
                    random.nextFloat() * world.getWidth(),
                    random.nextFloat() * world.getHeight());
        }
        for (int i = 0; i < 3; i++) {
            createPredator(
                    world,
                    random,
                    random.nextFloat() * world.getWidth(),
                    random.nextFloat() * world.getHeight());
        }
        for (int i = 0; i < 10000; i++) {
            world.update(0.01f);
        }
    }

    private static Creature createPlant(World world, float x, float y) {
        Creature creature = new Creature(new CreatureMediator(
                new WorldComponent(),
                new PositionComponent(),
                new ShapeComponent(new Circle(3f)),
                new CollisionComponent(),
                new MotionComponent(),
                new FleshComponent(FleshType.PLANT),
                new PlantBrain(),
                new PlantStomach(),
                new AlivenessComponent()));

        world.add(creature);
        creature.setPosition(x, y);
        return creature;
    }

    private static Creature createHerbivore(World world, Random random, float x, float y) {
        Creature creature = new Creature(new CreatureMediator(
                new WorldComponent(),
                new PositionComponent(),
                new ShapeComponent(new Circle(5f)),
                new CollisionComponent(),
                new MotionComponent(),
                new FleshComponent(FleshType.RICH_MEAT),
                new HerbivoreBrain(random, 3, 5, 10),
                new HerbivoreStomach(),
                new AlivenessComponent()));

        world.add(creature);
        creature.setPosition(x, y);
        return creature;
    }

    private static Creature createPredator(World world, Random random, float x, float y) {
        Creature creature = new Creature(new CreatureMediator(
                new WorldComponent(),
                new PositionComponent(),
                new ShapeComponent(new Circle(5f)),
                new CollisionComponent(),
                new MotionComponent(),
                new FleshComponent(FleshType.RICH_MEAT),
                new PredatorBrain(random, 3, 5, 10),
                new PredatorStomach(),
                new AlivenessComponent()));

        world.add(creature);
        creature.setPosition(x, y);
        return creature;
    }

}
