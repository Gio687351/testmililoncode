package refactula.snake;

import java.util.LinkedList;

public class Snake {
    private final SnakeGameConfig config;
    private final LinkedList<Cell> cells;
    private MoveDirection moveDirection;

    public Snake(SnakeGameConfig config) {
        cells = new LinkedList<>(config.getInitialSnakeCells());
        moveDirection = config.getInitialSnakeMoveDirection();
        this.config = config;
    }

    public void move(Cell nextCell, CellType nextCellType) {
        if (nextCellType == CellType.SNAKE) {
            return;
        }
        cells.add(nextCell);
        if (nextCellType == CellType.EMPTY) {
            cells.pollFirst();
        }
    }

    public Cell getNextCell() {
        return getNextCell(moveDirection);
    }

    private Cell getNextCell(MoveDirection moveDirection) {
        return new Cell(
                (cells.getLast().getColumn() + moveDirection.deltaColumn() + config.columns()) % config.columns(),
                (cells.getLast().getRow() + moveDirection.deltaRow() + config.rows()) % config.rows());
    }

    public void setMoveDirection(MoveDirection direction) {
        if (canMove(direction)) {
            this.moveDirection = direction;
        }
    }

    public boolean canMove(MoveDirection moveDirection) {
        Cell cell = getNextCell(moveDirection);
        return cells.size() < 2 || !cells.get(cells.size() - 2).equals(cell);
    }

    public boolean contains(Cell cell) {
        return cells.contains(cell);
    }

    public void draw(Painter painter) {
        for (Cell cell : cells) {
            painter.fill(cell.getColumn(), cell.getRow());
        }
    }
}
