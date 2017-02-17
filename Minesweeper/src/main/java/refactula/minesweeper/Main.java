package refactula.minesweeper;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper(10, 10, 10, new Random());
        SwingUtilities.invokeLater(() -> createAndShowGUI(minesweeper));
    }

    private static void createAndShowGUI(Minesweeper minesweeper) {
        createFontMetrics();
        int cellWidth = 30;
        int cellHeight = 30;
        int bombWidth = 20;
        int bombHeight = 20;
        int fontHeight = 20;
        JComponent canvas = new JComponent() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D g = (Graphics2D) graphics;
                g.setFont(g.getFont().deriveFont((float) fontHeight));
                synchronized (minesweeper) {
                    for (int x = 0; x < minesweeper.getWidth(); x++) {
                        for (int y = 0; y < minesweeper.getHeight(); y++) {
                            if (!minesweeper.isOpened(x, y)) {
                                g.setColor(Color.GRAY);
                                g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                            } else if (minesweeper.isMine(x, y)) {
                                if (minesweeper.isGameLost()) {
                                    g.setColor(Color.RED);
                                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                                }
                                g.setColor(Color.BLACK);
                                g.fillArc(
                                        x * cellWidth + (cellWidth - bombWidth) / 2,
                                        y * cellHeight + (cellHeight - bombHeight) / 2,
                                        bombWidth,
                                        bombHeight,
                                        0,
                                        360);
                            } else {
                                int minesAround = minesweeper.getMinesAround(x, y);
                                if (minesAround > 0) {
                                    g.setColor(Color.BLACK);
                                    String label = String.valueOf(minesAround);
                                    int labelWidth = g.getFontMetrics().stringWidth(label);
                                    int labelHeight = g.getFontMetrics().getAscent();
                                    g.drawString(
                                            label,
                                            x * cellWidth + (cellWidth - labelWidth) / 2,
                                            y * cellHeight + (cellHeight + labelHeight) / 2);
                                }
                            }
                            g.setColor(Color.BLACK);
                            g.drawRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                        }
                    }
                }
            }
        };
        canvas.setFocusable(true);
        canvas.setPreferredSize(new Dimension(minesweeper.getWidth() * cellWidth, minesweeper.getHeight() * cellHeight));
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / cellWidth;
                int y = e.getY() / cellHeight;
                synchronized (minesweeper) {
                    if (!minesweeper.isGameOver() && !minesweeper.isOpened(x, y)) {
                        minesweeper.open(x, y);
                        canvas.repaint();
                    }
                }
            }
        });

        JFrame frame = new JFrame("Minesweeper");
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void createFontMetrics() {
        new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY).createGraphics().getFontMetrics();
    }

}
