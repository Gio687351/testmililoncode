package refactula.design.patterns.behavioral.memento.chess;

public interface ChessPlayers {

  Player getPlayerToMove();

  void onPlayerMoved();

}
