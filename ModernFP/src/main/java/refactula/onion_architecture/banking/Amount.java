package refactula.onion_architecture.banking;

public final class Amount {
    private final int cents;

    public Amount(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }
}
