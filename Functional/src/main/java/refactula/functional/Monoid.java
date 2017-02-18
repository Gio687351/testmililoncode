package refactula.functional;

public interface Monoid<T> extends Semigroup<T> {

    T unit();

}
