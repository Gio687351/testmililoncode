package refactula.functional.matrix;

import refactula.functional.Semigroup;

public interface MatrixAlgebra {

    <T> Matrix<T> create(int columns, int rows, CellSupplier<T> cellSupplier);

    default <T> Matrix<T> create(int columns, int rows, T defaultValue) {
        return create(columns, rows, (c, r) -> defaultValue);
    }

    <T> Matrix<T> set(Matrix<T> m, int c, int r, T value);

    default <T> Semigroup<Matrix<T>> semigroupOf(Semigroup<T> child) {
        return (a, b) -> create(
                Math.min(a.columns(), b.columns()),
                Math.min(a.rows(), b.rows()),
                (c, r) -> child.combine(a.get(c, r), b.get(c, r)));
    }

    interface CellSupplier<T> {
        T get(int c, int r);
    }

}
