package refactula.introduction_to_algorithms.binary_search_tree;

public final class BinaryTree<E> extends AbstractBinaryTree<E, BinaryTree<E>> {
    @Override
    public BinaryTree<E> self() {
        return this;
    }
}
