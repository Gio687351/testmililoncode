package refactula.introduction_to_algorithms.utils.comparator;

public class ComparatorAdapter<T> implements Comparator<T> {
    private final java.util.Comparator<T> adaptee;

    public static <T extends Comparable<T>> Comparator<T> naturalOrder() {
        return new ComparatorAdapter<>(java.util.Comparator.naturalOrder());
    }

    public ComparatorAdapter(java.util.Comparator<T> adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public boolean is(T first, Comparison comparison, T second) {
        return comparison.matches(adaptee.compare(first, second));
    }
}
