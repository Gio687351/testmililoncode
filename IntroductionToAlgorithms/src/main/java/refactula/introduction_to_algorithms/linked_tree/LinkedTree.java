package refactula.introduction_to_algorithms.linked_tree;

import com.google.common.base.Preconditions;

public class LinkedTree<T> {
    private T value;
    private LinkedTree<T> parent;
    private LinkedTree<T> leftChild;
    private LinkedTree<T> rightSibling;

    public LinkedTree() {
    }

    public LinkedTree(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public LinkedTree<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public LinkedTree<T> parent() {
        return parent;
    }

    public LinkedTree<T> leftChild() {
        return leftChild;
    }

    public LinkedTree<T> rightSibling() {
        return rightSibling;
    }

    public LinkedTree<T> pushChild(LinkedTree<T> child) {
        Preconditions.checkNotNull(child);
        Preconditions.checkArgument(child.parent == null);
        Preconditions.checkArgument(child.rightSibling == null);
        child.parent = this;
        child.rightSibling = leftChild;
        leftChild = child;
        return this;
    }
}
