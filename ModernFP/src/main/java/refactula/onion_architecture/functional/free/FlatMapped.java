package refactula.onion_architecture.functional.free;

import java.util.function.Function;

public final class FlatMapped<X, Y> extends Free<Y> {
    private final Free<X> x;
    private final Function<X, Free<Y>> f;

    public FlatMapped(Free<X> x, Function<X, Free<Y>> f) {
        this.x = x;
        this.f = f;
    }
}
