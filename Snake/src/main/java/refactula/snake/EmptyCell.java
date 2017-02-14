package refactula.snake;

import java.awt.Graphics2D;

public class EmptyCell extends Cell {
    public static final EmptyCell INSTANCE = new EmptyCell();

    private EmptyCell() {
    }

    @Override
    public char getChar() {
        return '.';
    }

    @Override
    protected void doPaint(Graphics2D g, int x, int y, int width, int height) {
        g.drawRect(x, y, width, height);
    }
}
