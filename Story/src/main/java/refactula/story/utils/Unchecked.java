package refactula.story.utils;

import java.util.function.Function;

public class Unchecked {

    public static <T, R> Function<T, R> function(UnsafeFunction<T, R> f) {
        return obj -> {
            try {
                return f.apply(obj);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <T> T unchecked(UnsafeSupplier<T> supplier) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public interface UnsafeFunction<T, R> {
        R apply(T obj) throws Exception;
    }

    public interface UnsafeSupplier<T> {
        T get() throws Exception;
    }

}
