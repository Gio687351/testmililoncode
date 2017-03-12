package refactula.introduction_to_algorithms.queue;

public class ArrayQueueTest extends QueueTest {

    @Override
    protected <T> Queue<T> createQueue() {
        return new ArrayQueue<>();
    }

}