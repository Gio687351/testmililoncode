package refactula.design.patterns.behavioral.memento;

import com.google.common.base.Preconditions;
import refactula.design.patterns.behavioral.memento.chess.ChessBoard;
import refactula.design.patterns.behavioral.memento.chess.ChessMovement;
import refactula.design.patterns.behavioral.memento.chess.ChessPlayers;
import refactula.design.patterns.behavioral.memento.chess.Player;

public class ChessGame {
  private final ChessBoard chessBoard;
  private final ChessPlayers players;

  public ChessGame(ChessBoard chessBoard, ChessPlayers players) {
    this.chessBoard = chessBoard;
    this.players = players;
  }

  public void move() {
    Preconditions.checkState(!chessBoard.isInCheckmate());
    Player player = players.getPlayerToMove();
    for (boolean moveAccepted = false; !moveAccepted; ) {
      moveAccepted = attemptToMove(player);
    }
    players.onPlayerMoved();
  }

  private boolean attemptToMove(Player player) {
    ChessMovement chessMovement = player.requestMovement();
    Memento<ChessBoard> memento = chessBoard.createMemento();
    chessBoard.apply(chessMovement);
    if (chessBoard.isInCheck(player)) {
      // revert the movement if player ended up in a check
      chessBoard.setMemento(memento);
      return false;
    }
    return true;
  }
}
