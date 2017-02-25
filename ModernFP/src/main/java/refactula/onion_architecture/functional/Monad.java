package refactula.onion_architecture.functional;

import java.util.function.Function;

public interface Monad<X> extends Type<X> {

    <Y> Monad<Y> flatMap(Function<X, Monad<Y>> f);

    <Y> Monad<Y> map(Function<X, Y> function);

}
