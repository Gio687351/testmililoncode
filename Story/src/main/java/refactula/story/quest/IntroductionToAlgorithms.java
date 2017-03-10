package refactula.story.quest;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.skill.Algorithms;

import static refactula.story.markdown.Formatting.link;

public class IntroductionToAlgorithms extends Quest {
    private final Header header = new Header(3, "Introduction to Algorithms");

    public IntroductionToAlgorithms(Algorithms algorithms) {
        task("Insertion Sort", algorithms);
        task("Heapsort", algorithms);
        task("Quicksort", algorithms);
        task("Counting Sort", algorithms);
        task("Radix Sort", algorithms);
        task("Bucket Sort", algorithms);
        task("Order Statistics", algorithms);
        task("Stack", algorithms);
        task("Queue", algorithms);
        task("Linked List", algorithms);
        task("Hash Table", algorithms);
        task("Binary Search Tree", algorithms);
        task("Red-Black Tree", algorithms);
        task("Matrix-chain Multiplication", algorithms);
        task("Huffman Codes", algorithms);
        task("B-Tree", algorithms);
        task("Fibonacci Heap", algorithms);
        task("Van Emde Boas tree", algorithms);
        task("Disjoint Set", algorithms);
        task("Representations of graphs", algorithms);
        task("Breadth-first search", algorithms);
        task("Depth-first search", algorithms);
        task("Topological sort", algorithms);
        task("Strongly connected components", algorithms);
        task("Kruskal minimum spanning tree", algorithms);
        task("Prim minimum spanning tree", algorithms);
        task("Bellman-Ford algorithm", algorithms);
        task("Dijkstra’s algorithm", algorithms);
        task("Floyd-Warshall algorithm", algorithms);
        task("Ford-Fulkerson method", algorithms);
        task("RSA public-key cryptosystem", algorithms);
        task("The Knuth-Morris-Pratt algorithm", algorithms);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(MDLine.of("Implement algorithms from " + link("Introduction to Algorithms",
                "https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844") + " book."));
        writeTasks(writer);
    }
}
