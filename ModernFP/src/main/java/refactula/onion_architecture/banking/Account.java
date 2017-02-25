package refactula.onion_architecture.banking;

public final class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
