package refactula.design.patterns.creational.object_pool.mutable.fibonacci;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargeNumberTest {

    @Test
    public void testInitialZero() {
        LargeNumber n = new LargeNumber(1);
        assertEquals("0", n.toString());
    }

    @Test
    public void test15ToString() {
        LargeNumber n = new LargeNumber(2);
        n.set(15L);
        assertEquals("15", n.toString());
    }

    @Test
    public void test10000ToString() {
        LargeNumber n = new LargeNumber(10);
        n.set(10000L);
        assertEquals("10000", n.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testFailNegative() {
        LargeNumber n = new LargeNumber(10);
        n.set(-1L);
    }

    @Test
    public void testSimpleSum() {
        LargeNumber x = new LargeNumber(1);
        LargeNumber y = new LargeNumber(3);
        LargeNumber sum = new LargeNumber(2);
        x.set(4);
        y.set(3);
        sum.sum(x, y);
        assertEquals("7", sum.toString());
    }

    @Test
    public void testSumWithReminder() {
        LargeNumber x = new LargeNumber(16);
        LargeNumber y = new LargeNumber(16);
        LargeNumber sum = new LargeNumber(16);
        x.set(753);
        y.set(247);
        sum.sum(x, y);
        assertEquals("1000", sum.toString());
    }

    @Test
    public void test99999plus1() {
        LargeNumber x = new LargeNumber(16);
        LargeNumber y = new LargeNumber(16);
        LargeNumber sum = new LargeNumber(16);
        x.set(99999);
        y.set(1);
        sum.sum(x, y);
        assertEquals("100000", sum.toString());
    }

}