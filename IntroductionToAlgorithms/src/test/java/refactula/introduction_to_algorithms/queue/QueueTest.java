package refactula.introduction_to_algorithms.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;

public abstract class QueueTest {
    private final static Object FIRST = new Object();
    private final static Object SECOND = new Object();
    private final static Object THIRD = new Object();

    private Queue<Object> queue;

    @Before
    public void setup() {
        queue = createQueue();
    }

    protected abstract <T> Queue<T> createQueue();

    @Test
    public void shouldDequeueNullWhenEmpty() {
        assertNull(queue.dequeue());
    }

    @Test
    public void shouldSucceedEnqueue() {
        try {
            queue.enqueue(FIRST);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void shouldDequeueAfterEnqueue() {
        queue.enqueue(FIRST);
        assertEquals(FIRST, queue.dequeue());
    }

    @Test
    public void shouldBecomeEmptyAfterDequeue() {
        queue.enqueue(FIRST);
        queue.dequeue();
        assertEquals(null, queue.dequeue());
    }

    @Test
    public void shouldDequeueFirstAfterMultipleEnqueue() {
        queue.enqueue(FIRST);
        queue.enqueue(SECOND);
        assertEquals(FIRST, queue.dequeue());
    }

    @Test
    public void shouldDequeueTwo() {
        queue.enqueue(FIRST);
        queue.enqueue(SECOND);
        queue.dequeue();
        assertEquals(SECOND, queue.dequeue());
    }

    @Test
    public void shouldDequeueSecondAfterEmpty() {
        queue.enqueue(FIRST);
        queue.dequeue();
        queue.enqueue(SECOND);
        assertEquals(SECOND, queue.dequeue());
    }

    @Test
    public void shouldDequeueSecondAfterEnqueuingThird() {
        queue.enqueue(FIRST);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(SECOND);
        queue.enqueue(THIRD);
        assertEquals(SECOND, queue.dequeue());
    }

    @Test
    public void testSamples() {
        int samples = 10000;
        Random random = new Random("QueueTest".hashCode());
        for (int sample = 0; sample < samples; sample++) {
            Queue<Object> queue = createQueue();
            LinkedList<Object> expected = new LinkedList<>();
            int operations = 10 + random.nextInt(990);
            for (int operation = 0; operation < operations; operation++) {
                switch (random.nextInt(2)) {
                    case 0:
                        Object o = new Object();
                        queue.enqueue(o);
                        expected.push(o);
                        break;
                    case 1:
                        Object expectedObj = expected.pollLast();
                        Object actualObj = queue.dequeue();
                        assertEquals(expectedObj, actualObj);
                        break;
                }
            }
        }
    }
}
