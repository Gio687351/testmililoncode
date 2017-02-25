package refactula.onion_architecture.functional.either;

public final class Right<L, R> extends Either<L, R> {
    private final R value;

    public Right(R value) {
        this.value = value;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public L getLeft() {
        throw new RuntimeException("Right, not left");
    }

    @Override
    public R getRight() {
        return value;
    }
}
