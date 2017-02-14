package refactula.snake;

import java.awt.Color;
import java.awt.Graphics2D;

public enum Cell {

    EMPTY {
        @Override
        public char getChar() {
            return '.';
        }

        @Override
        protected void doPaint(Graphics2D g, int x, int y, int width, int height) {
            g.drawRect(x, y, width, height);
        }
    },

    RABBIT {
        @Override
        public char getChar() {
            return 'R';
        }

        @Override
        protected void doPaint(Graphics2D g, int x, int y, int width, int height) {
            g.fillRect(x, y, width, height);
        }
    },

    SNAKE {
        @Override
        public char getChar() {
            return '#';
        }

        @Override
        protected void doPaint(Graphics2D g, int x, int y, int width, int height) {
            g.fillRect(x, y, width, height);
        }
    };

    public abstract char getChar();

    public final void paint(Graphics2D g, int x, int y, int width, int height) {
        g.setColor(Color.BLACK);
        int insideWidth = width * 8 / 10;
        int insideHeight = height * 8 / 10;
        doPaint(g, x + (width - insideWidth) / 2, y + (height - insideHeight) / 2, insideWidth, insideHeight);
    }

    protected abstract void doPaint(Graphics2D g, int x, int y, int width, int height);
    
}
