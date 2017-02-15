package refactula.snake;

public enum MoveDirection {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int deltaColumn;
    private final int deltaRow;

    MoveDirection(int deltaColumn, int deltaRow) {
        this.deltaColumn = deltaColumn;
        this.deltaRow = deltaRow;
    }

    public int deltaColumn() {
        return deltaColumn;
    }

    public int deltaRow() {
        return deltaRow;
    }
}
