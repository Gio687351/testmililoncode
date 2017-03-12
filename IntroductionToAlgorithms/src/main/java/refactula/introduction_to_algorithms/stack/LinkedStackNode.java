package refactula.introduction_to_algorithms.stack;

class LinkedStackNode<T> {
    private T value;
    private LinkedStackNode<T> next;

    public static <T> LinkedStackNode<T> forValue(T value) {
        return create(value, null);
    }

    public static <T> LinkedStackNode<T> create(T value, LinkedStackNode<T> next) {
        LinkedStackNode<T> node = new LinkedStackNode<>();
        node.value = value;
        node.next = next;
        return node;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedStackNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedStackNode<T> next) {
        this.next = next;
    }
}
