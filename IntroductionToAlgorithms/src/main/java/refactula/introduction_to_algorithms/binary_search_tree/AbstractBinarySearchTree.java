package refactula.introduction_to_algorithms.binary_search_tree;

import refactula.introduction_to_algorithms.utils.comparator.Comparator;

import java.util.function.Consumer;

import static refactula.introduction_to_algorithms.binary_search_tree.Side.LEFT;
import static refactula.introduction_to_algorithms.binary_search_tree.Side.RIGHT;
import static refactula.introduction_to_algorithms.utils.comparator.Comparison.EQUAL_TO;
import static refactula.introduction_to_algorithms.utils.comparator.Comparison.LESS_THAN;
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

    public void inorderWalk(Consumer<T> valueConsumer) {
        visitLeft(left -> left.inorderWalk(valueConsumer));
        valueConsumer.accept(value());
        visitRight(right -> right.inorderWalk(valueConsumer));
    }

    public Self search(Comparator<T> comparator, T value) {
        Self tree = self();
        while (tree != null) {
            int comparison = comparator.compare(value, tree.value());
            if (EQUAL_TO.matches(comparison)) {
                return tree;
            }
            tree = LESS_THAN.matches(comparison) ? tree.left() : tree.right();
        }
        return null;
    }

    public Self extremum(Side side) {
        Self extremum = self();
        while (extremum.hasChild(side)) {
            extremum = extremum.child(side);
        }
        return extremum;
    }

    public Self minimum() {
        return extremum(LEFT);
    }

    public Self maximum() {
        return extremum(RIGHT);
    }

    public Self next(Side side) {
        if (hasChild(side)) {
            return child(side).extremum(side.opposite());
        }
        Self tree = self();
        while (tree.hasParent() && tree.isChild(side)) {
            tree = tree.parent();
        }
        return tree.parent();
    }

    public Self successor() {
        return next(RIGHT);
    }

    public Self predecessor() {
        return next(LEFT);
    }

    public Self insert(Comparator<T> comparator, Self node) {
        Self tree = self();
        boolean found = false;
        Side side;
        do {
            side = comparator.is(node.value(), LESS_THAN_OR_EQUAL_TO, tree.value()) ? LEFT : RIGHT;
            if (tree.hasChild(side)) {
                tree = tree.child(side);
            } else {
                found = true;
            }
        } while (!found);
        tree.attachChild(side, node);
        return self();
    }

}
