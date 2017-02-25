package refactula.onion_architecture.functional.either;

public final class Left<L, R> extends Either<L, R> {
    private final L value;

    public Left(L value) {
        this.value = value;
    }

    @Override
    public boolean isLeft() {
        return true;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public L getLeft() {
        return value;
    }

    @Override
    public R getRight() {
        throw new RuntimeException("Left, not right");
    }
}
