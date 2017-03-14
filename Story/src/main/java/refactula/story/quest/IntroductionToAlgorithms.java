package refactula.story.quest;

import refactula.story.Package;
import refactula.story.markdown.MDLine;
import refactula.story.skill.Algorithms;

import static refactula.story.markdown.Formatting.link;
import static refactula.story.markdown.MDElements.subheader;

public class IntroductionToAlgorithms extends Quest {

    public IntroductionToAlgorithms(Algorithms algorithms) {
        super("Introduction to Algorithms");

        writeln(MDLine.of("Implement algorithms from " + link("Introduction to Algorithms",
                "https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844") + " book."));

        Package questPackage = Package.create(
                "IntroductionToAlgorithms",
                "src",
                "main",
                "java",
                "refactula",
                "introduction_to_algorithms");

        writeln(subheader("Tasks"));
        write(done(questPackage.link("Insertion Sort", "insertion_sort"), algorithms));
        write(done(questPackage.link("Heapsort", "heapsort"), algorithms));
        write(done(questPackage.link("Quicksort", "quicksort"), algorithms));
        write(done(questPackage.link("Merge Sort", "merge_sort"), algorithms));
        write(done(questPackage.link("Counting Sort", "counting_sort"), algorithms));
        write(done(questPackage.link("Radix Sort", "radix_sort"), algorithms));
        write(done(questPackage.link("Bucket Sort", "bucket_sort"), algorithms));
        write(done(questPackage.link("Order Statistics", "order_statistics"), algorithms));
        write(done(questPackage.link("Stack", "stack"), algorithms));
        write(done(questPackage.link("Queue", "queue"), algorithms));
        write(done(questPackage.link("Linked List", "linked_list"), algorithms));
        write(done(questPackage.link("Binary Tree", "binary_tree"), algorithms));
        write(done(questPackage.link("Linked Tree", "linked_tree"), algorithms));
        write(done(questPackage.link("Hash Table", "hash_table"), algorithms));
        write(done(questPackage.link("Binary Search Tree", "binary_search_tree"), algorithms));
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
