package refactula.introduction_to_algorithms.binary_search_tree;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static refactula.introduction_to_algorithms.utils.comparator.Comparator.naturalOrder;

public class BinarySearchTreeTest {

    //        8
    //    3       10
    // 1    6         14
    //     4 7      13
    private BinarySearchTree<Integer> validTree;

    @Before
    public void setup() {
        validTree = tree(8,
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
    }

    private static <T> BinarySearchTree<T> leaf(T value) {
        return new BinarySearchTree<T>().setValue(value);
    }

    private static <T> BinarySearchTree<T> tree(T value, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        return new BinarySearchTree<T>()
                .setValue(value)
                .attachLeftIfNotNull(left)
                .attachRightIfNotNull(right);
    }

    @Test
    public void testValidBSTree() {
        assertTrue(validTree.isValid(naturalOrder()));
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

        assertFalse(tree.isValid(naturalOrder()));
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

        assertFalse(tree.isValid(naturalOrder()));
    }

    @Test
    public void testInorderWalk() {
        List<Integer> buffer = new ArrayList<>();
        validTree.inorderWalk(buffer::add);
        assertEquals(ImmutableList.of(1, 3, 4, 6, 7, 8, 10, 13, 14), buffer);
    }

    @Test
    public void testSearch() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 7);
        assertNotNull(node);
        assertEquals(Integer.valueOf(7), node.value());
    }

    @Test
    public void testSearchNotFound() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 9);
        assertNull(node);
    }

    @Test
    public void testMinimum() {
        BinarySearchTree<Integer> min = validTree.minimum();
        assertNotNull(min);
        assertEquals(Integer.valueOf(1), min.value());
    }

    @Test
    public void testMaximum() {
        BinarySearchTree<Integer> max = validTree.maximum();
        assertNotNull(max);
        assertEquals(Integer.valueOf(14), max.value());
    }

    @Test
    public void testSuccessor1() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 3);
        BinarySearchTree<Integer> successor = node.successor();
        assertNotNull(successor);
        assertEquals(Integer.valueOf(4), successor.value());
    }

    @Test
    public void testSuccessor2() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 7);
        BinarySearchTree<Integer> successor = node.successor();
        assertNotNull(successor);
        assertEquals(Integer.valueOf(8), successor.value());
    }

    @Test
    public void testSuccessor3() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 1);
        BinarySearchTree<Integer> successor = node.successor();
        assertNotNull(successor);
        assertEquals(Integer.valueOf(3), successor.value());
    }

    @Test
    public void testSuccessor4() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 14);
        BinarySearchTree<Integer> successor = node.successor();
        assertNull(successor);
    }

    @Test
    public void testPredecessor1() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 4);
        BinarySearchTree<Integer> predecessor = node.predecessor();
        assertNotNull(predecessor);
        assertEquals(Integer.valueOf(3), predecessor.value());
    }

    @Test
    public void testPredecessor2() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 8);
        BinarySearchTree<Integer> predecessor = node.predecessor();
        assertNotNull(predecessor);
        assertEquals(Integer.valueOf(7), predecessor.value());
    }

    @Test
    public void testPredecessor3() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 3);
        BinarySearchTree<Integer> predecessor = node.predecessor();
        assertNotNull(predecessor);
        assertEquals(Integer.valueOf(1), predecessor.value());
    }

    @Test
    public void testPredecessor4() {
        BinarySearchTree<Integer> node = validTree.search(naturalOrder(), 1);
        BinarySearchTree<Integer> predecessor = node.predecessor();
        assertNull(predecessor);
    }

    @Test
    public void testInsert1() {
        BinarySearchTree<Integer> node = new BinarySearchTree<Integer>().setValue(5);
        validTree.insert(naturalOrder(), node);
        assertNotNull(node.parent());
        assertEquals(Integer.valueOf(4), node.parent().value());
        assertTrue(node.isRight());
    }

    @Test
    public void testInsert2() {
        BinarySearchTree<Integer> node = new BinarySearchTree<Integer>().setValue(0);
        validTree.insert(naturalOrder(), node);
        assertNotNull(node.parent());
        assertEquals(Integer.valueOf(1), node.parent().value());
        assertTrue(node.isLeft());
    }

    @Test
    public void testInsert3() {
        BinarySearchTree<Integer> node = new BinarySearchTree<Integer>().setValue(2);
        validTree.insert(naturalOrder(), node);
        assertNotNull(node.parent());
        assertEquals(Integer.valueOf(1), node.parent().value());
        assertTrue(node.isRight());
    }

    @Test
    public void testInsert4() {
        BinarySearchTree<Integer> node = new BinarySearchTree<Integer>().setValue(15);
        validTree.insert(naturalOrder(), node);
        assertNotNull(node.parent());
        assertEquals(Integer.valueOf(14), node.parent().value());
        assertTrue(node.isRight());
    }

    @Test
    public void testInsert5() {
        BinarySearchTree<Integer> node = new BinarySearchTree<Integer>().setValue(9);
        validTree.insert(naturalOrder(), node);
        assertNotNull(node.parent());
        assertEquals(Integer.valueOf(10), node.parent().value());
        assertTrue(node.isLeft());
    }

}
