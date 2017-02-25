package refactula.onion_architecture.functional;

import java.util.function.Function;

public interface Monad<X> extends Algebra<X> {

    <Y> Monad<Y> flatMap(Function<X, Monad<Y>> f);

}
