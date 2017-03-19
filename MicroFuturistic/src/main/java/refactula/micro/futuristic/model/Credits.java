package refactula.micro.futuristic.model;

import com.google.common.base.Preconditions;

public final class Credits {
    private final int amount;

    public static Credits withAmount(int amount) {
        return new Credits(amount);
    }

    public Credits(int amount) {
        Preconditions.checkArgument(amount >= 0, "negative amount: %s", amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credits credits = (Credits) o;

        return amount == credits.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }

    @Override
    public String toString() {
        return "Credits{" +
                "amount=" + amount +
                '}';
    }

    public Credits plus(Credits credits) {
        return new Credits(amount + credits.amount);
    }

    public static Credits ofNullable(Credits credits) {
        return credits == null ? new Credits(0) : credits;
    }

    public Credits minus(Credits credits) {
        return new Credits(amount - credits.amount);
    }
}
