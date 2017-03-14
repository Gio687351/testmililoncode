package refactula.introduction_to_algorithms.binary_search_tree;

import org.junit.Test;
import refactula.introduction_to_algorithms.utils.comparator.Comparator;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private static <T> BinarySearchTree<T> leaf(T value) {
        return new BinarySearchTree<T>().setValue(value);
    }

    private static <T> BinarySearchTree<T> tree(T value, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        return new BinarySearchTree<T>().setValue(value).setLeft(left).setRight(right);
    }

    //        8
    //    3       10
    // 1    6         14
    //     4 7      13
    @Test
    public void testValidBSTree() {
        BinarySearchTree<Integer> tree = tree(8,
                tree(3,
                        leaf(1),
                        tree(6,
                                leaf(4),
                                leaf(7))),
                tree(10,
                        null,
                        tree(14,
                                leaf(13),
                                null)));

        assertTrue(tree.isValid(Comparator.naturalOrder()));
    }

    //        8
    //    3       10
    // 1    6         14
    //     4 5      13
    @Test
    public void testInvalidBSTree1() {
        BinarySearchTree<Integer> tree = tree(8,
                tree(3,
                        leaf(1),
                        tree(6,
                                leaf(4),
                                leaf(5))),
                tree(10,
                        null,
                        tree(14,
                                leaf(13),
                                null)));

        assertFalse(tree.isValid(Comparator.naturalOrder()));
    }

    //        5
    //    3       10
    // 1    6         14
    //     4 7      13
    @Test
    public void testInvalidBSTree2() {
        BinarySearchTree<Integer> tree = tree(8,
                tree(3,
                        leaf(1),
                        tree(6,
                                leaf(4),
                                leaf(5))),
                tree(10,
                        null,
                        tree(14,
                                leaf(13),
                                null)));

        assertFalse(tree.isValid(Comparator.naturalOrder()));
    }

}