package refactula.snake;

import java.awt.Graphics2D;

public class RabbitCell extends Cell {
    public static final RabbitCell INSTANCE = new RabbitCell();

    private RabbitCell() {
    }

    @Override
    public char getChar() {
        return 'R';
    }

    @Override
    protected void doPaint(Graphics2D g, int x, int y, int width, int height) {
        g.fillRect(x, y, width, height);
    }
}
