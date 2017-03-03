package refactula.story;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevelCalculatorTest {

    private LevelCalculator levelCalculator;

    @Before
    public void setup() {
        levelCalculator = new LevelCalculator(100, 200);
    }

    @Test
    public void testLinesBeforeCompleted1() {
        assertEquals(0, levelCalculator.getLinesBeforeCompleted(1));
    }

    @Test
    public void testLinesAfterCompleted1() {
        assertEquals(100, levelCalculator.getLinesAfterCompleted(1));
    }

    @Test
    public void testLinesAfterCompleted100() {
        assertEquals(1000000, levelCalculator.getLinesAfterCompleted(100));
    }

}