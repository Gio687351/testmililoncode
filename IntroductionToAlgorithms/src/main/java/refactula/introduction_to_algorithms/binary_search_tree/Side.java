package refactula.introduction_to_algorithms.binary_search_tree;

public enum Side {
    LEFT {
        @Override
        public Side opposite() {
            return RIGHT;
        }
    },
    RIGHT {
        @Override
        public Side opposite() {
            return LEFT;
        }
    };

    public abstract Side opposite();
}
