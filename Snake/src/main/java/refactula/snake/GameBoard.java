package refactula.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private final GameConfig config;
    private final Random random;
    private final Snake snake;
    private final Rabbit rabbit;

    public GameBoard(GameConfig config, Random random, Snake snake, Rabbit rabbit) {
        this.config = config;
        this.random = random;
        this.snake = snake;
        this.rabbit = rabbit;
        this.respawnRabbit();
    }

    public void draw(Painter painter) {
        snake.draw(painter);
        rabbit.draw(painter);
    }

    public void moveSnake() {
        if (isGameOver()) {
            return;
        }
        Cell nextCell = snake.getNextCell();
        CellType cellType = getCellType(nextCell);
        snake.move(nextCell, cellType);
        if (cellType == CellType.RABBIT) {
            respawnRabbit();
        }
    }

    private void respawnRabbit() {
        List<Cell> availableCells = new ArrayList<>();
        for (int column = 0; column < config.columns(); column++) {
            for (int row = 0; row < config.rows(); row++) {
                Cell cell = new Cell(column, row);
                if (getCellType(cell) == CellType.EMPTY) {
                    availableCells.add(cell);
                }
            }
        }
        if (!availableCells.isEmpty()) {
            rabbit.respawn(availableCells.get(random.nextInt(availableCells.size())));
        }
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
        if (isGameOver()) {
            return;
        }
        snake.setMoveDirection(newDirection);
    }

    public boolean isGameOver() {
        return snake.isStuck();
    }
}
