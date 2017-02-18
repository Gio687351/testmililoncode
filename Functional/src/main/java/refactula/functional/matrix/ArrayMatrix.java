package refactula.functional.matrix;

public class ArrayMatrix<T> implements Matrix<T> {
    private final int columns;
    private final int rows;
    private final Object[][] values;

    private ArrayMatrix(int columns, int rows, Object[][] values) {
        this.columns = columns;
        this.rows = rows;
        this.values = values;
    }

    @Override
    public int columns() {
        return columns;
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int column, int row) {
        return (T) values[column][row];
    }

    public static <T> Builder<T> builder(int columns, int rows) {
        return new Builder<>(columns, rows);
    }

    public static class Builder<T> {
        private final int columns;
        private final int rows;
        private final Object[][] values;

        private Builder(int columns, int rows) {
            this.columns = columns;
            this.rows = rows;
            this.values = new Object[columns][rows];
        }

        public int columns() {
            return columns;
        }

        public int rows() {
            return rows;
        }

        @SuppressWarnings("unchecked")
        public T get(int c, int r) {
            return (T) values[c][r];
        }

        public Builder<T> set(int c, int r, T value) {
            values[c][r] = value;
            return this;
        }

        public ArrayMatrix<T> build() {
            Object[][] snapshot = new Object[columns][rows];
            for (int c = 0; c < columns; c++) {
                for (int r = 0; r < rows; r++) {
                    snapshot[c][r] = values[c][r];
                }
            }
            return new ArrayMatrix<>(columns, rows, snapshot);
        }
    }
}
