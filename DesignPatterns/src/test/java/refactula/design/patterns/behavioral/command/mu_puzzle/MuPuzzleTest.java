package refactula.design.patterns.behavioral.command.mu_puzzle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MuPuzzleTest {
    private MuPuzzle muPuzzle;

    @Before
    public void setup() {
        muPuzzle = new MuPuzzle();
    }

    @Test
    public void testInitialState() {
        assertEquals("MI", muPuzzle.toString());
    }

    @Test
    public void testAppendU() {
        muPuzzle.appendU();
        assertEquals("MIU", muPuzzle.toString());
    }

    @Test
    public void testDoubleStringAfterM() {
        muPuzzle.appendU();
        muPuzzle.doubleStringAfterM();
        assertEquals("MIUIU", muPuzzle.toString());
    }

    @Test
    public void testReplaceIIIWithU() {
        muPuzzle.doubleStringAfterM();
        muPuzzle.doubleStringAfterM();
        muPuzzle.replaceIIIWithU(1);
        assertEquals("MUI", muPuzzle.toString());
    }

    @Test
    public void testReplaceIIIWithUDifferentIndex() {
        muPuzzle.doubleStringAfterM();
        muPuzzle.doubleStringAfterM();
        muPuzzle.replaceIIIWithU(2);
        assertEquals("MIU", muPuzzle.toString());
    }

    @Test
    public void testRemoveUU() {
        muPuzzle.appendU();
        muPuzzle.appendU();
        muPuzzle.removeUU(2);
        assertEquals("MI", muPuzzle.toString());
    }
}