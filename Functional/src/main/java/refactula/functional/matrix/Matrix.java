package refactula.functional.matrix;

public interface Matrix<T> {

    int columns();

    int rows();

    T get(int column, int row);

}
