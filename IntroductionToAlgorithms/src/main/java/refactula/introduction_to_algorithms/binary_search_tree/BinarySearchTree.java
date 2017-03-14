package refactula.introduction_to_algorithms.binary_search_tree;

public final class BinarySearchTree<T> extends AbstractBinarySearchTree<T, BinarySearchTree<T>> {
    @Override
    public BinarySearchTree<T> self() {
        return this;
    }
}
