package refactula.introduction_to_algorithms.utils.comparator;

public interface Comparator<T> extends java.util.Comparator<T> {

    boolean is(T first, Comparison comparison, T second);

}
