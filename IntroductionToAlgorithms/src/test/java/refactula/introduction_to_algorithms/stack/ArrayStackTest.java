package refactula.introduction_to_algorithms.stack;

public class ArrayStackTest extends StackTest {

    @Override
    protected <T> Stack<T> createStack() {
        return new ArrayStack<>();
    }

}