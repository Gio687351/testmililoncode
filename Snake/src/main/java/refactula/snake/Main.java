package refactula.snake;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Main {

    public static void main(String[] args) {
        Snake snake = new Snake(10, 10);

        JComponent canvas = new JComponent() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D g = (Graphics2D) graphics;
                snake.paint(g);
            }
        };
        canvas.setPreferredSize(new Dimension(snake.getCanvasWidth(), snake.getCanvasHeight()));

        JFrame frame = new JFrame();
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
