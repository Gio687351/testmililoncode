package refactula.introduction_to_algorithms.binary_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    //        3
    //     5     2
    //   4   6     8
    //      2
    @Test
    public void testBasicUsage() {
        BinaryTree<Integer> tree =
                tree(3)
                        .attachLeftChild(tree(5)
                                .attachLeftChild(tree(4))
                                .attachRightChild(tree(6)
                                        .attachLeftChild(tree(2))))
                        .attachRightChild(tree(2)
                                .attachRightChild(tree(8)));
        assertEquals(3 * (5 * (4 + 6 * 2) + 2 * 8), evaluate(tree));
    }

    private static BinaryTree<Integer> tree(int value) {
        return new BinaryTree<>(value);
    }

    private long evaluate(BinaryTree<Integer> node) {
        if (node == null) {
            return 0;
        } else if (node.leftChild() == null && node.rightChild() == null) {
            return node.value();
        } else {
            return node.value() * (evaluate(node.leftChild()) + evaluate(node.rightChild()));
        }
    }

}
