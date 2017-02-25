package refactula.onion_architecture.functional.either;

public abstract class Either<L, R> {

    Either() {}

    public abstract boolean isLeft();

    public abstract boolean isRight();

    public abstract L getLeft();

    public abstract R getRight();

    public static <L, R> Left<L, R> left(L value) {
        return new Left<>(value);
    }

    public static <L, R> Right<L, R> right(R value) {
        return new Right<>(value);
    }
}
