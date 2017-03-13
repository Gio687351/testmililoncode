package refactula.introduction_to_algorithms.linked_tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedTreeTest {

    @Test
    public void testUsage() {
        LinkedTree<Node> list = list()
                .pushChild(leaf(6))
                .pushChild(list()
                        .pushChild(leaf(5))
                        .pushChild(list()
                                .pushChild(leaf(4))
                                .pushChild(leaf(3))))
                .pushChild(list()
                        .pushChild(leaf(2))
                        .pushChild(leaf(1)));

        assertEquals("(list (list 1 2) (list (list 3 4) 5) 6)", toString(list));
    }

    private String toString(LinkedTree<Node> list) {
        StringBuilder builder = new StringBuilder();
        traverse(list, builder, true);
        return builder.toString();
    }

    private void traverse(LinkedTree<Node> tree, StringBuilder builder, boolean isFirst) {
        if (tree == null) {
            return;
        }
        if (!isFirst) {
            builder.append(' ');
        }
        if (tree.value() instanceof List) {
            builder.append("(list");
            traverse(tree.leftChild(), builder, false);
            builder.append(")");
        } else if (tree.value() instanceof Leaf) {
            Leaf leaf = (Leaf) tree.value();
            builder.append(leaf.getValue());
        }
        traverse(tree.rightSibling(), builder, false);
    }

    private LinkedTree<Node> list() {
        return new LinkedTree<>(List.INSTANCE);
    }

    private LinkedTree<Node> leaf(int value) {
        return new LinkedTree<>(new Leaf(value));
    }

    private interface Node {
    }

    private enum List implements Node {
        INSTANCE
    }

    private static final class Leaf implements Node {
        private final int value;

        private Leaf(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}