package refactula.onion_architecture.functional.free;

import refactula.onion_architecture.functional.Type;

public final class Suspend<X> extends Free<X> {
    private final Type<X> type;

    public Suspend(Type<X> type) {
        this.type = type;
    }

    public Type<X> getType() {
        return type;
    }
}
