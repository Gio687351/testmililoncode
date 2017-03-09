package refactula.design.patterns.behavioral.memento.chess;

public class BoardPosition {
  private final int column;
  private final int row;

  public BoardPosition(int column, int row) {
    this.column = column;
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public int getRow() {
    return row;
  }
}
