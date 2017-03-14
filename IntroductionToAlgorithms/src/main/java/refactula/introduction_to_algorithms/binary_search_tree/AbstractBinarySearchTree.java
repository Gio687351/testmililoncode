package refactula.introduction_to_algorithms.binary_search_tree;

import refactula.introduction_to_algorithms.utils.comparator.Comparator;

import static refactula.introduction_to_algorithms.utils.comparator.Comparison.LESS_THAN_OR_EQUAL_TO;

public abstract class AbstractBinarySearchTree<T, Self extends AbstractBinarySearchTree<T, Self>> extends AbstractBinaryTree<T, Self> {

    public boolean isValid(Comparator<T> comparator) {
        return isValid(null, comparator, null);
    }

    protected final boolean isValid(T lowerBound, Comparator<T> comparator, T upperBound) {
        return (lowerBound == null || comparator.is(lowerBound, LESS_THAN_OR_EQUAL_TO, value())) &&
                (upperBound == null || comparator.is(value(), LESS_THAN_OR_EQUAL_TO, upperBound)) &&
                (left() == null || left().isValid(lowerBound, comparator, value())) &&
                (right() == null || right().isValid(value(), comparator, upperBound));
    }

}
