package refactula.design.patterns.behavioral.memento.chess;

public class ChessMovement {
  private final BoardPosition from;
  private final BoardPosition to;

  public ChessMovement(BoardPosition from, BoardPosition to) {
    this.from = from;
    this.to = to;
  }

  public BoardPosition getFrom() {
    return from;
  }

  public BoardPosition getTo() {
    return to;
  }
}
