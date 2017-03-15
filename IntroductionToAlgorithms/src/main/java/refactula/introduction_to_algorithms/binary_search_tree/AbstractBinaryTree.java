package refactula.introduction_to_algorithms.binary_search_tree;

import java.util.function.Consumer;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static refactula.introduction_to_algorithms.binary_search_tree.Side.LEFT;
import static refactula.introduction_to_algorithms.binary_search_tree.Side.RIGHT;

public abstract class AbstractBinaryTree<T, Self extends AbstractBinaryTree<T, Self>> implements SelfType<Self> {
    private final Children<Self> children = new Children<>();
    private Self parent;
    private T value;

    public T value() {
        return value;
    }

    public Self setValue(T value) {
        this.value = value;
        return self();
    }

    public Self parent() {
        return parent;
    }

    public Self setParent(Self parent) {
        this.parent = parent;
        return self();
    }

    public boolean hasParent() {
        return parent != null;
    }

    public Self child(Side side) {
        return children.get(side);
    }

    public boolean hasChild(Side side) {
        return child(side) != null;
    }

    public boolean hasLeft() {
        return hasChild(LEFT);
    }

    public boolean hasRight() {
        return hasChild(RIGHT);
    }

    public void visitChild(Side side, Consumer<Self> visitor) {
        if (hasChild(side)) {
            visitor.accept(child(side));
        }
    }

    public void visitLeft(Consumer<Self> visitor) {
        visitChild(LEFT, visitor);
    }

    public void visitRight(Consumer<Self> visitor) {
        visitChild(RIGHT, visitor);
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

    public boolean isChild(Side side) {
        return hasParent() && self() == parent().child(side);
    }

    public boolean isLeft() {
        return isChild(LEFT);
    }

    public boolean isRight() {
        return isChild(RIGHT);
    }

    public Self attachChild(Side side, Self child) {
        checkState(!hasChild(side));
        checkNotNull(child);
        checkArgument(child.parent() == null);

        return setChild(side, child.setParent(self()));
    }

    public Self attachLeft(Self child) {
        return attachChild(LEFT, child);
    }

    public Self attachRight(Self child) {
        return attachChild(RIGHT, child);
    }

    public Self attachChildIfNotNull(Side side, Self child) {
        return child == null ? self() : attachChild(side, child);
    }

    public Self attachLeftIfNotNull(Self child) {
        return attachChildIfNotNull(LEFT, child);
    }

    public Self attachRightIfNotNull(Self child) {
        return attachChildIfNotNull(RIGHT, child);
    }
}
