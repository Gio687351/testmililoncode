package refactula.design.patterns.creational.prototype;

import org.junit.Before;
import org.junit.Test;
import refactula.design.patterns.creational.prototype.TicTacToe.Mark;
import refactula.design.patterns.creational.prototype.TicTacToe.Position;

import java.util.Random;

import static org.junit.Assert.*;

public class ComputerPlayerTest {

    private TicTacToe classic;
    private ComputerPlayer computerPlayer;

    @Before
    public void setup() {
        classic = TicTacToe.createClassic();
        computerPlayer = new ComputerPlayer(new Random(315317534));
    }

    @Test
    public void suggestCrossWinMove() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 2, 0);
        classic.put(Mark.CROSS, 0, 2);
        classic.put(Mark.NOUGHT, 2, 2);
        Position position = computerPlayer.suggestMove(classic);
        assertEquals(0, position.column);
        assertEquals(1, position.row);
    }

    @Test
    public void suggestNoughtWinMove() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 2, 0);
        classic.put(Mark.CROSS, 0, 2);
        classic.put(Mark.NOUGHT, 2, 2);
        classic.put(Mark.CROSS, 1, 1);
        Position position = computerPlayer.suggestMove(classic);
        assertEquals(2, position.column);
        assertEquals(1, position.row);
    }

    @Test
    public void shouldSucceedSuggestInitialPosition() {
        try {
            computerPlayer.suggestMove(classic);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test(expected = RuntimeException.class)
    public void failSuggestIfGameOver() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 0, 1);
        classic.put(Mark.CROSS, 1, 0);
        classic.put(Mark.NOUGHT, 1, 1);
        classic.put(Mark.CROSS, 2, 1);
        classic.put(Mark.NOUGHT, 2, 0);
        classic.put(Mark.CROSS, 0, 2);
        classic.put(Mark.NOUGHT, 1, 2);
        classic.put(Mark.CROSS, 2, 2);
        computerPlayer.suggestMove(classic);
    }

    @Test
    public void shouldSuggestOnlyPositionLeft() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 0, 1);
        classic.put(Mark.CROSS, 1, 0);
        classic.put(Mark.NOUGHT, 1, 1);
        classic.put(Mark.CROSS, 2, 1);
        classic.put(Mark.NOUGHT, 2, 0);
        classic.put(Mark.CROSS, 0, 2);
        classic.put(Mark.NOUGHT, 1, 2);
        Position position = computerPlayer.suggestMove(classic);
        assertEquals(2, position.column);
        assertEquals(2, position.row);
    }

}