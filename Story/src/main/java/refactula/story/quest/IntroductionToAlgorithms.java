package refactula.story.quest;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDElements;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.skill.Algorithms;

import static refactula.story.markdown.Formatting.link;
import static refactula.story.markdown.MDElements.subheader;

public class IntroductionToAlgorithms extends Quest {

    public IntroductionToAlgorithms(Algorithms algorithms) {
        super("Introduction to Algorithms");

        writeln(MDLine.of("Implement algorithms from " + link("Introduction to Algorithms",
                "https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844") + " book."));

        writeln(subheader("Tasks"));
        write(task("Insertion Sort", algorithms));
        write(task("Heapsort", algorithms));
        write(task("Quicksort", algorithms));
        write(task("Counting Sort", algorithms));
        write(task("Radix Sort", algorithms));
        write(task("Bucket Sort", algorithms));
        write(task("Order Statistics", algorithms));
        write(task("Stack", algorithms));
        write(task("Queue", algorithms));
        write(task("Linked List", algorithms));
        write(task("Hash Table", algorithms));
        write(task("Binary Search Tree", algorithms));
        write(task("Red-Black Tree", algorithms));
        write(task("Matrix-chain Multiplication", algorithms));
        write(task("Huffman Codes", algorithms));
        write(task("B-Tree", algorithms));
        write(task("Fibonacci Heap", algorithms));
        write(task("Van Emde Boas tree", algorithms));
        write(task("Disjoint Set", algorithms));
        write(task("Representations of graphs", algorithms));
        write(task("Breadth-first search", algorithms));
        write(task("Depth-first search", algorithms));
        write(task("Topological sort", algorithms));
        write(task("Strongly connected components", algorithms));
        write(task("Kruskal minimum spanning tree", algorithms));
        write(task("Prim minimum spanning tree", algorithms));
        write(task("Bellman-Ford algorithm", algorithms));
        write(task("Dijkstra’s algorithm", algorithms));
        write(task("Floyd-Warshall algorithm", algorithms));
        write(task("Ford-Fulkerson method", algorithms));
        write(task("RSA public-key cryptosystem", algorithms));
        writeln(task("The Knuth-Morris-Pratt algorithm", algorithms));
    }

}
