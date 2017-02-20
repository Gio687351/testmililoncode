package refactula.design.patterns.prototype;

import com.google.common.base.Preconditions;
import refactula.design.patterns.prototype.TicTacToe.Position;

import java.util.Random;

/**
 * ComputerPlayer creates copies and experiments with them to find game winning move.
 */
public class ComputerPlayer {
    private final Random random;

    public ComputerPlayer(Random random) {
        this.random = random;
    }

    public Position suggestMove(TicTacToe ticTacToe) {
        Preconditions.checkState(!ticTacToe.isGameOver());
        Position randomPosition = null;
        int randomCounter = 0;
        for (int column = 0; column < ticTacToe.getBoardWidth(); column++) {
            for (int row = 0; row < ticTacToe.getBoardHeight(); row++) {
                if (ticTacToe.isEmpty(column, row)) {
                    TicTacToe sandbox = ticTacToe.createCopy();
                    sandbox.put(ticTacToe.getNextMark(), column, row);
                    if (sandbox.isGameOver() && sandbox.getGameWinner() == ticTacToe.getNextMark()) {
                        return new Position(column, row);
                    }
                    randomCounter++;
                    if (random.nextInt(randomCounter) == 0) {
                        randomPosition = new Position(column, row);
                    }
                }
            }
        }
        return randomPosition;
    }
}
