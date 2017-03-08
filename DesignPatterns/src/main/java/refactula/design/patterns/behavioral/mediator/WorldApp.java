package refactula.design.patterns.behavioral.mediator;

import refactula.design.patterns.behavioral.mediator.component.*;
import refactula.design.patterns.behavioral.mediator.shape.Circle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class WorldApp {

    public static void main(String[] args) {
        World world = new World(1000f, 800f);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            createPlant(
                    world,
                    random.nextFloat() * world.getWidth(),
                    random.nextFloat() * world.getHeight());
        }
        for (int i = 0; i < 100; i++) {
            createHerbivore(
                    world,
                    random,
                    random.nextFloat() * world.getWidth(),
                    random.nextFloat() * world.getHeight());
        }
        for (int i = 0; i < 30; i++) {
            createPredator(
                    world,
                    random,
                    random.nextFloat() * world.getWidth(),
                    random.nextFloat() * world.getHeight());
        }

        JComponent canvas = new JComponent() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                GraphicsPainter painter = new GraphicsPainter((Graphics2D) graphics);
                synchronized (world) {
                    world.draw(painter);
                }
            }
        };
        canvas.setPreferredSize(new Dimension(Math.round(world.getWidth()), Math.round(world.getHeight())));

        JFrame frame = new JFrame();
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (world) {
                world.update(0.01f);
            }
            frame.repaint();
        }
        System.exit(0);
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
                new AlivenessComponent(),
                new PainterComponent(Color.GREEN)));

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
                new HerbivoreBrain(random, 10, 50, 60),
                new HerbivoreStomach(),
                new AlivenessComponent(),
                new PainterComponent(Color.BLUE)));

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
                new FleshComponent(FleshType.LEAN_MEAT),
                new PredatorBrain(random, 10, 30, 100),
                new PredatorStomach(),
                new AlivenessComponent(),
                new PainterComponent(Color.RED)));

        world.add(creature);
        creature.setPosition(x, y);
        return creature;
    }

}
