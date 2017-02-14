package refactula.snake;

public class Grid {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = Cell.EMPTY;
            }
        }
    }

    public Cell get(int x, int y) {
        return cells[x][y];
    }

    public void set(int x, int y, Cell cell) {
        cells[x][y] = cell;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                builder.append(cells[x][y].getChar());
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
