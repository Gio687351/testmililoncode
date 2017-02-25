package refactula.onion_architecture.banking;

public final class TransferError implements TransferResult {
    private final Error error;

    public TransferError(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
