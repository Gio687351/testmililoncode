package refactula.snake;

public class Rabbit {
    private final SnakeGameConfig config;
    private int column;
    private int row;

    public Rabbit(SnakeGameConfig config) {
        this.config = config;
        this.column = config.getInitialRabbitColumn();
        this.row = config.getInitialRabbitRow();
    }

    public void draw(Painter painter) {
        painter.fill(column, row);
    }

    public boolean isIn(Cell cell) {
        return cell.getColumn() == column && cell.getRow() == row;
    }
}
