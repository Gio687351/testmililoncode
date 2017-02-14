package refactula.snake;

import java.awt.Graphics2D;

public class SnakeCell extends Cell {
    public static final SnakeCell LEFT = new SnakeCell(-1, 0);
    public static final SnakeCell RIGHT = new SnakeCell(1, 0);
    public static final SnakeCell DOWN = new SnakeCell(0, -1);
    public static final SnakeCell UP = new SnakeCell(0, 1);

    private final int neighbourDx;
    private final int neighbourDy;

    private SnakeCell(int neighbourDx, int neighbourDy) {
        this.neighbourDx = neighbourDx;
        this.neighbourDy = neighbourDy;
    }

    @Override
    public char getChar() {
        return '#';
    }

    @Override
    protected void doPaint(Graphics2D g, int x, int y, int width, int height) {
        g.fillRect(x, y, width, height);
    }
}
