package refactula.introduction_to_algorithms.binary_search_tree;

class Children<T> {
    private T left;
    private T right;

    public T get(Side side) {
        switch (side) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
        }
        return null;
    }

    public void set(Side side, T value) {
        switch (side) {
            case LEFT:
                left = value;
                break;
            case RIGHT:
                right = value;
                break;
        }
    }
}
