package refactula.design.patterns.structural.proxy.property;

public class InMemoryProperty<T> implements Property<T> {
    private T value;

    public InMemoryProperty(T initialValue) {
        this.value = initialValue;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public void set(T newValue) {
        this.value = newValue;
    }
}
