package refactula.design.patterns.behavioral.memento.chess;

import refactula.design.patterns.behavioral.memento.Originator;

public interface ChessBoard extends Originator<ChessBoard> {

  void apply(ChessMovement chessMovement);

  boolean isInCheckmate();

  boolean isInCheck(Player player);

}
