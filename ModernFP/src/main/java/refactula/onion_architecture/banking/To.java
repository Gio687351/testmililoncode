package refactula.onion_architecture.banking;

public final class To<X> {
    private final X value;

    public To(X value) {
        this.value = value;
    }

    public X getValue() {
        return value;
    }
}
