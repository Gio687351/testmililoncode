package refactula.introduction_to_algorithms.binary_tree;

import com.google.common.base.Preconditions;

public class BinaryTree<T> {
    private T value;
    private BinaryTree<T> parent;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
    }

    public BinaryTree(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public BinaryTree<T> parent() {
        return parent;
    }

    public BinaryTree<T> leftChild() {
        return leftChild;
    }

    public BinaryTree<T> rightChild() {
        return rightChild;
    }

    public BinaryTree<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public BinaryTree<T> attachLeftChild(BinaryTree<T> node) {
        Preconditions.checkNotNull(node);
        Preconditions.checkState(leftChild == null);
        Preconditions.checkArgument(node.parent == null);
        leftChild = node;
        node.parent = this;
        return this;
    }

    public BinaryTree<T> attachRightChild(BinaryTree<T> node) {
        Preconditions.checkNotNull(node);
        Preconditions.checkState(rightChild == null);
        Preconditions.checkArgument(node.parent == null);
        rightChild = node;
        node.parent = this;
        return this;
    }

    public BinaryTree<T> detachLeftChild() {
        if (leftChild == null) {
            return null;
        }
        BinaryTree<T> result = leftChild;
        leftChild.parent = null;
        leftChild = null;
        return result;
    }

    public BinaryTree<T> detachRightChild() {
        if (rightChild == null) {
            return null;
        }
        BinaryTree<T> result = rightChild;
        rightChild.parent = null;
        rightChild = null;
        return result;
    }

    public BinaryTree<T> detachParent() {
        if (parent == null) {
            return null;
        }
        BinaryTree<T> result = parent;
        if (parent.leftChild == this) {
            parent.leftChild = null;
        }
        if (parent.rightChild == this) {
            parent.rightChild = null;
        }
        parent = null;
        return result;
    }
}
