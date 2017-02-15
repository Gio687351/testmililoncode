package refactula.snake;

public class Rabbit {
    private Cell cell;

    public void draw(Painter painter) {
        painter.fill(cell.getColumn(), cell.getRow());
    }

    public boolean isIn(Cell cell) {
        return cell.equals(this.cell);
    }

    public void respawn(Cell cell) {
        this.cell = cell;
    }
}
