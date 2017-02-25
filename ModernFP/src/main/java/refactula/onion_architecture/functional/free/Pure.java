package refactula.onion_architecture.functional.free;

public final class Pure<X> extends Free<X> {
    private final X value;

    public Pure(X value) {
        this.value = value;
    }

    public X getValue() {
        return value;
    }
}
