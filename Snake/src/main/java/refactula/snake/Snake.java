package refactula.snake;

import com.google.common.base.Preconditions;

import java.util.LinkedList;

public class Snake {
    private final GameConfig config;
    private final LinkedList<Cell> cells;
    private MoveDirection moveDirection;
    private boolean isStuck = false;

    public Snake(GameConfig config) {
        this.cells = new LinkedList<>(config.getInitialSnakeCells());
        this.moveDirection = config.getInitialSnakeMoveDirection();
        this.config = config;
    }

    public void move(Cell nextCell, CellType nextCellType) {
        Preconditions.checkState(!isStuck, "snake is stuck");
        if (nextCellType == CellType.SNAKE) {
            isStuck = true;
            return;
        }
        cells.add(nextCell);
        if (nextCellType == CellType.EMPTY) {
            cells.pollFirst();
        }
    }

    public boolean isStuck() {
        return isStuck;
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
            moveDirection = direction;
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
