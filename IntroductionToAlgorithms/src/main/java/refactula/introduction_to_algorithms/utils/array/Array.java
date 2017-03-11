package refactula.introduction_to_algorithms.utils.array;

public interface Array<T> {

    int length();

    T get(int index);

    void set(int index, T value);

}
