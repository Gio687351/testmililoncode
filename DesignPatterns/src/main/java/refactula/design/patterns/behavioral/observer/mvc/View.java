package refactula.design.patterns.behavioral.observer.mvc;

import refactula.design.patterns.behavioral.observer.mvc.Model.ReadonlyCircle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class View implements Model.Listener {
    private final Random random;

    private final JFrame frame;
    private final JComponent canvas;

    private final ConcurrentMap<ReadonlyCircle, CirclePainter> painters = new ConcurrentHashMap<>();
    private volatile String phrase = "";

    public View(Random random, float width, float height) {
        this.random = random;

        canvas = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
                for (CirclePainter painter : painters.values()) {
                    painter.paint(g);
                }
                g.setColor(Color.WHITE);
                g.setFont(g.getFont().deriveFont(Font.BOLD, 60));
                String currentPhrase = phrase;
                g.drawString(currentPhrase,
                        (getWidth() - g.getFontMetrics().stringWidth(currentPhrase)) / 2,
                        (getHeight() + g.getFontMetrics().getAscent()) / 2);
                frame.repaint();
            }
        };
        canvas.setPreferredSize(new Dimension((int) Math.ceil(width), (int) Math.ceil(height)));

        frame = new JFrame();
        frame.add(canvas);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void onCircleAdded(ReadonlyCircle circle) {
        painters.put(circle, new CirclePainter(
                new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                Math.round(circle.getX() - circle.getRadius()),
                Math.round(circle.getY() - circle.getRadius()),
                Math.round(2 * circle.getRadius())
        ));
    }

    @Override
    public void onCircleUpdated(ReadonlyCircle circle) {
        painters.get(circle).set(
                Math.round(circle.getX() - circle.getRadius()),
                Math.round(circle.getY() - circle.getRadius()),
                Math.round(2 * circle.getRadius()));
    }

    @Override
    public void onCircleRemoved(ReadonlyCircle circle) {
        painters.remove(circle);
    }

    @Override
    public void onPhraseChanged(String phrase) {
        this.phrase = phrase;
    }

    private static final class CirclePainter {
        private final Color color;
        private int x;
        private int y;
        private int diameter;

        private CirclePainter(Color color, int x, int y, int diameter) {
            this.color = color;
            this.x = x;
            this.y = y;
            this.diameter = diameter;
        }

        public synchronized void set(int x, int y, int diameter) {
            this.x = x;
            this.y = y;
            this.diameter = diameter;
        }

        private synchronized void paint(Graphics g) {
            g.setColor(color);
            g.fillArc(x, y, diameter, diameter, 0, 360);
        }
    }
}
