package refactula.design.patterns.creational.prototype;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * Prototype design pattern. Represented by presence of createCopy() method.
 *
 * @see ComputerPlayer ComputerPlayer creates copies and experiments with them to find game winning move
 */
public class TicTacToe {
    private static final int CLASSIC_WIDTH = 3;
    private static final int CLASSIC_HEIGHT = 3;
    private static final ImmutableList<Combination> CLASSIC_COMBINATIONS = ImmutableList.of(
            new Combination(ImmutableList.of(new Position(0, 0), new Position(1, 0), new Position(2, 0))),
            new Combination(ImmutableList.of(new Position(0, 1), new Position(1, 1), new Position(2, 1))),
            new Combination(ImmutableList.of(new Position(0, 2), new Position(1, 2), new Position(2, 2))),
            new Combination(ImmutableList.of(new Position(0, 0), new Position(0, 1), new Position(0, 2))),
            new Combination(ImmutableList.of(new Position(1, 0), new Position(1, 1), new Position(1, 2))),
            new Combination(ImmutableList.of(new Position(2, 0), new Position(2, 1), new Position(2, 2))),
            new Combination(ImmutableList.of(new Position(0, 0), new Position(1, 1), new Position(2, 2))),
            new Combination(ImmutableList.of(new Position(0, 2), new Position(1, 1), new Position(2, 0))));

    public enum Mark { CROSS, NOUGHT }

    private final int boardWidth;
    private final int boardHeight;
    private final Mark[][] board;
    private final ImmutableList<Combination> combinations;
    private Mark nextMark = Mark.CROSS;
    private boolean isGameOver = false;
    private Mark gameWinner = null;
    private int emptyCells;

    public static TicTacToe createClassic() {
        return new TicTacToe(CLASSIC_WIDTH, CLASSIC_HEIGHT, CLASSIC_COMBINATIONS);
    }

    public TicTacToe(int boardWidth, int boardHeight, ImmutableList<Combination> combinations) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.combinations = combinations;
        this.board = new Mark[boardWidth][boardHeight];
        this.emptyCells = boardWidth * boardHeight;
    }

    public TicTacToe createCopy() {
        TicTacToe ticTacToe = new TicTacToe(boardWidth, boardHeight, combinations);
        for (int column = 0; column < boardWidth; column++) {
            System.arraycopy(board[column], 0, ticTacToe.board[column], 0, boardHeight);
        }
        ticTacToe.isGameOver = isGameOver;
        ticTacToe.gameWinner = gameWinner;
        ticTacToe.nextMark = nextMark;
        ticTacToe.emptyCells = emptyCells;
        return ticTacToe;
    }

    public void put(Mark mark, int column, int row) {
        Preconditions.checkArgument(mark == nextMark);
        Preconditions.checkState(!isGameOver);
        Preconditions.checkState(isEmpty(column, row));
        board[column][row] = mark;
        nextMark = mark == Mark.CROSS ? Mark.NOUGHT : Mark.CROSS;
        if (combinations.stream().anyMatch(c -> c.positions.stream().allMatch(p -> board[p.column][p.row] == mark))) {
            isGameOver = true;
            gameWinner = mark;
        }
        if (--emptyCells == 0 && !isGameOver) {
            isGameOver = true;
        }
    }

    public Mark getNextMark() { return nextMark; }

    public int getBoardWidth() { return boardWidth; }

    public int getBoardHeight() { return boardHeight; }

    public boolean isEmpty(int column, int row) { return board[column][row] == null; }

    public boolean isGameOver() { return isGameOver; }

    public Mark getGameWinner() { return gameWinner; }

    public static class Combination {
        public final ImmutableList<Position> positions;

        public Combination(ImmutableList<Position> positions) { this.positions = positions; }
    }

    public static class Position {
        public final int column, row;

        public Position(int column, int row) { this.column = column; this.row = row; }
    }
}
