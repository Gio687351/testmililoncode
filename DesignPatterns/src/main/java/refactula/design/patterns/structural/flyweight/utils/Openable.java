package refactula.design.patterns.structural.flyweight.utils;

import com.google.common.base.Objects;

public abstract class Openable<T> {
    private Openable() {}

    public static <T> Open<T> open(T value) {
        return new Open<>(value);
    }

    public static <T> Closed<T> closed() {
        //noinspection unchecked
        return (Closed<T>) Closed.INSTANCE;
    }

    public abstract boolean isOpen();

    public abstract T get();

    public static final class Closed<T> extends Openable<T> {
        private static final Closed INSTANCE = new Closed();

        private Closed() {}

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public T get() {
            throw new RuntimeException("Closed");
        }
    }

    public static final class Open<T> extends Openable<T> {
        private final T value;

        private Open(T value) {
            this.value = value;
        }

        @Override
        public boolean isOpen() {
            return true;
        }

        @Override
        public T get() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Open<?> open = (Open<?>) o;
            return Objects.equal(value, open.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }
    }
}
