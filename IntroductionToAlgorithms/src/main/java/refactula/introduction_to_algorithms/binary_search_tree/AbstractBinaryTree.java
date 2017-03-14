package refactula.introduction_to_algorithms.binary_search_tree;

import java.util.Random;

import static refactula.introduction_to_algorithms.binary_search_tree.Side.*;

public abstract class AbstractBinaryTree<T, Self extends AbstractBinaryTree<T, Self>> implements SelfType<Self> {
    private final Children<Self> children = new Children<>();
    private T value;

    public T value() {
        return value;
    }

    public Self setValue(T value) {
        this.value = value;
        return self();
    }

    public Self child(Side side) {
        return children.get(side);
    }

    public Self setChild(Side side, Self value) {
        children.set(side, value);
        return self();
    }

    public Self left() {
        return child(LEFT);
    }

    public Self setLeft(Self left) {
        return setChild(LEFT, left);
    }

    public Self right() {
        return child(RIGHT);
    }

    public Self setRight(Self right) {
        return setChild(RIGHT, right);
    }
}
