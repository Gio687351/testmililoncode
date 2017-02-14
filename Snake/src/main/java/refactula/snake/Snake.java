package refactula.snake;

import java.util.concurrent.ThreadLocalRandom;

public class Snake {
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
}
