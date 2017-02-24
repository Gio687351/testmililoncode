package refactula.design.patterns.structural.proxy.property;

import java.util.function.Function;

public interface Property<T> {

    T get();

    void set(T newValue);

    default void update(Function<T, T> atomicUpdater) {
        set(atomicUpdater.apply(get()));
    }

}
