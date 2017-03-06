package refactula.design.patterns.behavioral.iterator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphNode<T> {
    private final T value;
    private final Set<GraphNode<T>> connections = new HashSet<>();

    public GraphNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setConnected(GraphNode<T> otherNode, boolean connected) {
        updateConnection(otherNode, connected);
        otherNode.updateConnection(this, connected);
    }

    private void updateConnection(GraphNode<T> otherNode, boolean connected) {
        if (connected) {
            connections.add(otherNode);
        } else {
            connections.remove(otherNode);
        }
    }

    public Iterator<T> bfsIterator() {
        return new BreadthFirstSearchIterator<>(this);
    }

    private static final class BreadthFirstSearchIterator<T> implements Iterator<T> {
        private final Set<GraphNode<T>> enqueued = new HashSet<>();
        private final Queue<GraphNode<T>> queue = new LinkedList<>();

        public BreadthFirstSearchIterator(GraphNode<T> firstToVisit) {
            enqueued.add(firstToVisit);
            queue.add(firstToVisit);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            GraphNode<T> node = queue.poll();
            for (GraphNode<T> connected : node.connections) {
                if (!enqueued.contains(connected)) {
                    enqueued.add(connected);
                    queue.add(connected);
                }
            }
            return node.value;
        }
    }

    public Iterator<T> dfsIterator() {
        return new DepthFirstSearchIterator<>(this);
    }

    private static final class DepthFirstSearchIterator<T> implements Iterator<T> {
        private GraphNode<T> next;
        private final LinkedList<java.util.Iterator<GraphNode<T>>> stack = new LinkedList<>();
        private final Set<GraphNode<T>> enqueued = new HashSet<>();

        public DepthFirstSearchIterator(GraphNode<T> firstToVisit) {
            next = firstToVisit;
            stack.add(firstToVisit.connections.iterator());
            enqueued.add(firstToVisit);
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T result = next.getValue();
            next = null;
            while (next == null && !stack.isEmpty()) {
                if (stack.getLast().hasNext()) {
                    GraphNode<T> nextCandidate = stack.getLast().next();
                    if (enqueued.add(nextCandidate)) {
                        next = nextCandidate;
                        stack.add(next.connections.iterator());
                    }
                } else {
                    stack.removeLast();
                }
            }
            return result;
        }
    }
}
