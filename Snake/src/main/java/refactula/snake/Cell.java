package refactula.snake;

import com.google.common.base.Objects;

public final class Cell {
    private final int column;
    private final int row;

    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return column == cell.column &&
                row == cell.row;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(column, row);
    }
}
