package refactula.snake;

import com.google.common.collect.ImmutableList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {
        SnakeGameConfig snakeGameConfig = SnakeGameConfig.builder()
                .setColumns(10)
                .setRows(10)
                .setInitialSnakeCells(ImmutableList.of(
                        new Cell(0, 0),
                        new Cell(1, 0),
                        new Cell(2, 0),
                        new Cell(2, 1),
                        new Cell(3, 1)))
                .setInitialSnakeMoveDirection(MoveDirection.RIGHT)
                .setInitialRabbitColumn(9)
                .setInitialRabbitRow(6)
                .build();

        Object lock = new Object();
        SnakeBoard snakeBoard = new SnakeBoard(snakeGameConfig, new Snake(snakeGameConfig), new Rabbit(snakeGameConfig));

        SnakeViewConfig viewConfig = SnakeViewConfig.builder()
                .setColumns(snakeGameConfig.columns())
                .setRows(snakeGameConfig.rows())
                .setCellWidthPx(40)
                .setCellHeightPx(40)
                .setBackgroundColor(Color.YELLOW)
                .setColor(Color.BLACK)
                .build();

        JComponent canvas = new JComponent() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D g = (Graphics2D) graphics;
                g.setBackground(viewConfig.getBackgroundColor());
                g.clearRect(0, 0, getWidth(), getHeight());
                DesktopPainter painter = new DesktopPainter(viewConfig, g);
                synchronized (lock) {
                    snakeBoard.draw(painter);
                }
            }
        };
        canvas.setPreferredSize(new Dimension(viewConfig.getViewWidthPx(), viewConfig.getViewHeightPx()));
        canvas.setFocusable(true);
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                MoveDirection newDirection = null;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        newDirection = MoveDirection.RIGHT;
                        break;
                    case KeyEvent.VK_LEFT:
                        newDirection = MoveDirection.LEFT;
                        break;
                    case KeyEvent.VK_UP:
                        newDirection = MoveDirection.UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        newDirection = MoveDirection.DOWN;
                        break;
                }
                if (newDirection != null) {
                    synchronized (lock) {
                        snakeBoard.setSnakeDirection(newDirection);
                    }
                }
            }
        });

        JFrame frame = new JFrame();
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
            while (true) {
                Thread.sleep(200);
                synchronized (lock) {
                    snakeBoard.moveSnake();
                }
                frame.repaint();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
