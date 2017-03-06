package refactula.design.patterns.behavioral.iterator;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphNodeTest {

    private GraphNode<String> parent;

    @Before
    public void setup() {
        parent = new GraphNode<>("parent");
        GraphNode<String> child1 = new GraphNode<>("child");
        GraphNode<String> child2 = new GraphNode<>("child");
        GraphNode<String> grandchild1 = new GraphNode<>("grandchild");
        GraphNode<String> grandchild2 = new GraphNode<>("grandchild");
        parent.setConnected(child1, true);
        parent.setConnected(child2, true);
        child1.setConnected(grandchild1, true);
        child2.setConnected(grandchild2, true);
    }

    @Test
    public void testBreadthFirstSearch() {
        List<String> elements = new ArrayList<>();
        for (Iterator<String> iterator = parent.bfsIterator(); iterator.hasNext(); ) {
            elements.add(iterator.next());
            assertTrue(elements.size() <= 5);
        }
        assertEquals(ImmutableList.of("parent", "child", "child", "grandchild", "grandchild"), elements);
    }

    @Test
    public void testDepthFirstSearch() {
        List<String> elements = new ArrayList<>();
        for (Iterator<String> iterator = parent.dfsIterator(); iterator.hasNext(); ) {
            elements.add(iterator.next());
            assertTrue(elements.size() <= 5);
        }
        assertEquals(ImmutableList.of("parent", "child", "grandchild", "child", "grandchild"), elements);
    }

}
