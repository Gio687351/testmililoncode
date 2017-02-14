package refactula.snake;

import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;

public class Snake {
    public static final int CELL_WIDTH_PX = 50;
    public static final int CELL_HEIGHT_PX = 50;

    private Grid grid;

    public Snake(int width, int height) {
        grid = new Grid(width, height);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < Math.min(width, height); i++) {
            grid.set(random.nextInt(width), random.nextInt(height), Cell.SNAKE);
        }
        grid.set(random.nextInt(width), random.nextInt(height), Cell.RABBIT);
    }

    @Override
    public String toString() {
        return grid.toString();
    }

    public int getWidth() {
        return grid.getWidth();
    }

    public int getHeight() {
        return grid.getHeight();
    }

    public int getCanvasWidth() {
        return CELL_HEIGHT_PX * getWidth();
    }

    public int getCanvasHeight() {
        return CELL_WIDTH_PX * getHeight();
    }

    public void paint(Graphics2D g) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                grid.get(x, y).paint(g, x * CELL_WIDTH_PX, y * CELL_HEIGHT_PX, CELL_WIDTH_PX, CELL_HEIGHT_PX);
            }
        }
    }
}
