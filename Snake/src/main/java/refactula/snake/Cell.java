package refactula.snake;

public enum Cell {

    EMPTY {
        @Override
        public char getChar() {
            return '.';
        }
    },

    RABBIT {
        @Override
        public char getChar() {
            return 'R';
        }
    },

    SNAKE {
        @Override
        public char getChar() {
            return '#';
        }
    };

    public abstract char getChar();

}
