package refactula.argorithms.data.structure.mutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<String> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void emptyListGetHead() {
        assertNull(list.getHead());
    }

    @Test
    public void emptyListGetTail() {
        assertNull(list.getTail());
    }

    @Test
    public void emptyListPullHead() {
        assertNull(list.pullHead());
    }

    @Test
    public void emptyListPullTail() {
        assertNull(list.pullTail());
    }

    @Test
    public void addHeadAndGetHead() {
        list.addHead("first");
        assertEquals("first", list.getHead());
    }

    @Test
    public void addHeadAndGetTail() {
        list.addHead("first");
        assertEquals("first", list.getTail());
    }

    @Test
    public void addHeadAndPullHead() {
        list.addHead("first");
        assertEquals("first", list.pullHead());
    }

    @Test
    public void addHeadAndPullTail() {
        list.addHead("first");
        assertEquals("first", list.pullTail());
    }

    @Test
    public void addHeadAndPullTailBecomesEmpty() {
        list.addHead("first");
        list.pullTail();
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void addHeadAndPullHeadBecomesEmpty() {
        list.addHead("first");
        list.pullHead();
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void addTailAndPullTailBecomesEmpty() {
        list.addTail("first");
        list.pullTail();
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void addTailAndPullHeadBecomesEmpty() {
        list.addTail("first");
        list.pullHead();
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void multipleAddHeadAndPullHead() {
        list.addHead("first");
        list.addHead("second");
        list.addHead("third");
        assertEquals("third", list.pullHead());
        assertEquals("second", list.pullHead());
        assertEquals("first", list.pullHead());
    }

    @Test
    public void multipleAddHeadAndPullTail() {
        list.addHead("first");
        list.addHead("second");
        list.addHead("third");
        assertEquals("first", list.pullTail());
        assertEquals("second", list.pullTail());
        assertEquals("third", list.pullTail());
    }

    @Test
    public void multipleAddTailAndPullHead() {
        list.addTail("first");
        list.addTail("second");
        list.addTail("third");
        assertEquals("first", list.pullHead());
        assertEquals("second", list.pullHead());
        assertEquals("third", list.pullHead());
    }

    @Test
    public void multipleAddTailAndPullTail() {
        list.addTail("first");
        list.addTail("second");
        list.addTail("third");
        assertEquals("third", list.pullTail());
        assertEquals("second", list.pullTail());
        assertEquals("first", list.pullTail());
    }

}