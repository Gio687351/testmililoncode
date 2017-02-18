package refactula.functional.matrix;

import refactula.functional.matrix.ArrayMatrix.Builder;

public class ArrayMatrixAlgebra implements MatrixAlgebra {

    @Override
    public <T> Matrix<T> create(int columns, int rows, CellSupplier<T> cellSupplier) {
        return BuilderDSL
                .<T>ofSize(columns, rows)
                .readFrom(cellSupplier)
                .build();
    }

    @Override
    public <T> Matrix<T> set(Matrix<T> m, int c, int r, T value) {
        return BuilderDSL
                .fromMatrix(m)
                .set(c, r, value)
                .build();
    }

    private static class BuilderDSL<T> {
        final ArrayMatrix.Builder<T> builder;

        static <T> BuilderDSL<T> ofSize(int columns, int rows) {
            return new BuilderDSL<T>(ArrayMatrix.builder(columns, rows));
        }

        static <T> BuilderDSL<T> fromMatrix(Matrix<T> m) {
            return BuilderDSL
                    .<T>ofSize(m.columns(), m.rows())
                    .readFrom(m::get);
        }

        BuilderDSL(Builder<T> builder) {
            this.builder = builder;
        }

        BuilderDSL<T> readFrom(CellSupplier<T> supplier) {
            for (int c = 0; c < builder.columns(); c++) {
                for (int r = 0; r < builder.rows(); r++) {
                    builder.set(c, r, supplier.get(c, r));
                }
            }
            return this;
        }

        ArrayMatrix<T> build() {
            return builder.build();
        }

        BuilderDSL<T> set(int c, int r, T value) {
            builder.set(c, r, value);
            return this;
        }
    }

}
