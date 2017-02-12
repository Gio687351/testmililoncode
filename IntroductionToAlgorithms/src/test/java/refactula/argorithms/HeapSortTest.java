package refactula.argorithms;

public class HeapSortTest extends AbstractSortTest {

    @Override
    protected void sort(int[] a) {
        HeapSort.sort(a);
    }

}