package refactula.onion_architecture.banking;

public final class From<X> {
    private final X value;

    public From(X value) {
        this.value = value;
    }

    public X getValue() {
        return value;
    }
}
