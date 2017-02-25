package refactula.onion_architecture.functional;

import java.util.function.Supplier;

public interface Unchecked {

    static <T> Supplier<T> of(CheckedSupplier<T> checkedSupplier) {
        return () -> {
            try {
                return checkedSupplier.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    interface CheckedSupplier<T> {
        T get() throws Exception;
    }

}
