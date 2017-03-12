package refactula.introduction_to_algorithms.stack;

public class LinkedStackTest extends StackTest {

    @Override
    protected <T> Stack<T> createStack() {
        return new LinkedStack<>();
    }
}