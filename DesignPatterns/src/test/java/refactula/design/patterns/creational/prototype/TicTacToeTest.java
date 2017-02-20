package refactula.design.patterns.creational.prototype;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import refactula.design.patterns.creational.prototype.TicTacToe.Mark;

import static org.junit.Assert.*;

public class TicTacToeTest {

    private TicTacToe classic;

    @Before
    public void setup() {
        classic = TicTacToe.createClassic();
    }

    @Test
    public void testClassicInitialState() {
        assertEquals(3, classic.getBoardWidth());
        assertEquals(3, classic.getBoardHeight());
        Assert.assertEquals(Mark.CROSS, classic.getNextMark());
        assertFalse(classic.isGameOver());
    }

    @Test
    public void testSucceedPutCross() {
        try {
            classic.put(Mark.CROSS, 0, 0);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void testShouldSwitchToNought() {
        classic.put(Mark.CROSS, 0, 0);
        assertEquals(Mark.NOUGHT, classic.getNextMark());
    }

    @Test(expected = RuntimeException.class)
    public void testFailPutNought() {
        classic.put(Mark.NOUGHT, 0, 0);
    }

    @Test
    public void testSucceedPutNought() {
        classic.put(Mark.CROSS, 0, 2);
        try {
            classic.put(Mark.NOUGHT, 1, 0);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void testShouldSwitchToCross() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 1, 2);
        assertEquals(Mark.CROSS, classic.getNextMark());
    }

    @Test(expected = RuntimeException.class)
    public void testFailPutCross() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.CROSS, 1, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testFailToPutOnOccupied() {
        classic.put(Mark.CROSS, 0, 1);
        classic.put(Mark.NOUGHT, 0, 1);
    }

    @Test(expected = RuntimeException.class)
    public void testFailToPutSameOccupied() {
        classic.put(Mark.CROSS, 0, 1);
        classic.put(Mark.NOUGHT, 2, 1);
        classic.put(Mark.CROSS, 0, 1);
    }

    @Test
    public void testCrossWin() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 0, 1);
        classic.put(Mark.CROSS, 1, 0);
        classic.put(Mark.NOUGHT, 2, 1);
        classic.put(Mark.CROSS, 2, 0);
        assertTrue(classic.isGameOver());
        assertEquals(Mark.CROSS, classic.getGameWinner());
    }

    @Test
    public void testNoughtWin() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 2, 0);
        classic.put(Mark.CROSS, 1, 0);
        classic.put(Mark.NOUGHT, 0, 2);
        classic.put(Mark.CROSS, 2, 2);
        classic.put(Mark.NOUGHT, 1, 1);
        assertTrue(classic.isGameOver());
        assertEquals(Mark.NOUGHT, classic.getGameWinner());
    }

    @Test
    public void testTie() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 0, 1);
        classic.put(Mark.CROSS, 1, 0);
        classic.put(Mark.NOUGHT, 1, 1);
        classic.put(Mark.CROSS, 2, 1);
        classic.put(Mark.NOUGHT, 2, 0);
        classic.put(Mark.CROSS, 0, 2);
        classic.put(Mark.NOUGHT, 1, 2);
        classic.put(Mark.CROSS, 2, 2);
        assertTrue(classic.isGameOver());
        assertNull(classic.getGameWinner());
    }

    @Test(expected = RuntimeException.class)
    public void testCannotMoveAfterGameOver() {
        classic.put(Mark.CROSS, 0, 0);
        classic.put(Mark.NOUGHT, 0, 1);
        classic.put(Mark.CROSS, 1, 0);
        classic.put(Mark.NOUGHT, 2, 1);
        classic.put(Mark.CROSS, 2, 0);
        classic.put(Mark.NOUGHT, 2, 2);
    }

}