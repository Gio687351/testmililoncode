package refactula.introduction_to_algorithms.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class StackTest {
    private static final String MESSAGE1 = "First";
    private static final String MESSAGE2 = "Second";

    private Stack<String> stack;

    @Before
    public void setup() {
        stack = createStack();
    }

    protected abstract <T> Stack<T> createStack();

    @Test
    public void shouldBeEmptyWhenCreated() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void shouldPushWithoutErrors() {
        try {
            stack.push(MESSAGE1);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void shouldPopNullWhenEmpty() {
        assertNull(stack.pop());
    }

    @Test
    public void shouldPopAfterPush() {
        stack.push(MESSAGE1);
        assertEquals(MESSAGE1, stack.pop());
    }

    @Test
    public void shouldBecomeEmptyAfterPop() {
        stack.push(MESSAGE1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void shouldPopNullAfterBecameEmpty() {
        stack.push(MESSAGE1);
        stack.pop();
        assertNull(stack.pop());
    }

    @Test
    public void shouldPushAndPopAfterBecameEmpty() {
        stack.push(MESSAGE1);
        stack.pop();
        stack.push(MESSAGE2);
        assertEquals(MESSAGE2, stack.pop());
    }

    @Test
    public void shouldPopLastMessage() {
        stack.push(MESSAGE1);
        stack.push(MESSAGE2);
        assertEquals(MESSAGE2, stack.pop());
    }

    @Test
    public void shouldPopAfterLast() {
        stack.push(MESSAGE1);
        stack.push(MESSAGE2);
        stack.pop();
        assertEquals(MESSAGE1, stack.pop());
    }
}
