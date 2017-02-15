package refactula.snake;

public class SnakeBoard {
    private final SnakeGameConfig snakeGameConfig;
    private final Snake snake;
    private final Rabbit rabbit;

    public SnakeBoard(SnakeGameConfig snakeGameConfig, Snake snake, Rabbit rabbit) {
        this.snakeGameConfig = snakeGameConfig;
        this.snake = snake;
        this.rabbit = rabbit;
    }

    public void draw(Painter painter) {
        snake.draw(painter);
        rabbit.draw(painter);
    }

    public void moveSnake() {
        Cell nextCell = snake.getNextCell();
        CellType cellType = getCellType(nextCell);
        snake.move(nextCell, cellType);
    }

    private CellType getCellType(Cell cell) {
        if (snake.contains(cell)) {
            return CellType.SNAKE;
        }
        if (rabbit.isIn(cell)) {
            return CellType.RABBIT;
        }
        return CellType.EMPTY;
    }

    public void setSnakeDirection(MoveDirection newDirection) {
        if (snake.canMove(newDirection)) {

        }
        snake.setMoveDirection(newDirection);
    }
}
