package refactula.snake;

import java.awt.Graphics2D;

public class DesktopPainter implements Painter {
    private final SnakeViewConfig config;
    private final Graphics2D graphics;

    public DesktopPainter(SnakeViewConfig config, Graphics2D graphics) {
        this.config = config;
        this.graphics = graphics;
    }

    @Override
    public int columns() {
        return config.columns();
    }

    @Override
    public int rows() {
        return config.rows();
    }

    @Override
    public void fill(int column, int row) {
        graphics.setColor(config.getColor());
        graphics.fillRect(
                column * config.getCellWidthPx(),
                row * config.getCellHeightPx(),
                config.getCellWidthPx(),
                config.getCellHeightPx());
    }
}
