package refactula.onion_architecture.functional.free;

import refactula.onion_architecture.functional.Type;

import java.util.function.Function;

public abstract class Free<X> implements Type<X> {
    Free() {}

    public static <X> Free<X> pure(X x) {
        return new Pure<>(x);
    }

    public static <X> Free<X> liftF(Type<X> type) {
        return new Suspend<>(type);
    }

    public static <X> Free<X> suspend(Free<X> value) {
        return pure(null).flatMap(ignored -> value);
    }

    private <Y> Free<Y> flatMap(Function<X, Free<Y>> f) {
        return new FlatMapped<>(this, f);
    }
}
