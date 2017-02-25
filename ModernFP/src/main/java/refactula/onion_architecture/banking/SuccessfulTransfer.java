package refactula.onion_architecture.banking;

public class SuccessfulTransfer implements TransferResult {
    private final From<Amount> from;
    private final To<Amount> to;

    public SuccessfulTransfer(From<Amount> from, To<Amount> to) {
        this.from = from;
        this.to = to;
    }

    public From<Amount> getFrom() {
        return from;
    }

    public To<Amount> getTo() {
        return to;
    }
}
