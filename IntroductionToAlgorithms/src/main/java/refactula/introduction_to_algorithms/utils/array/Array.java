package refactula.introduction_to_algorithms.utils.array;

public interface Array<T> {

    int length();

    T get(int index);

    void set(int index, T value);

    default void swap(int i, int j) {
        T tmp = get(i);
        set(i, get(j));
        set(j, tmp);
    }

}
