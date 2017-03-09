package refactula.design.patterns.behavioral.memento;

public class ChessGameExample {

    public boolean move(ChessBoard board, ChessPlayer player, ChessMovement movement) {
        Memento<ChessBoard> memento = board.createMemento();
        board.apply(movement);
        if (board.isInCheck(player)) {
            // revert the movement if after it the player is in check
            board.setMemento(memento);
            return false;
        }
        return true;
    }

    interface ChessBoard extends Originator<ChessBoard> {
        void apply(ChessMovement movement);

        boolean isInCheck(ChessPlayer player);
    }

    interface ChessPlayer {}

    interface ChessMovement {}

}
