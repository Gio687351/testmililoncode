package refactula.design.patterns.abstract_factory.graphical;

import refactula.design.patterns.abstract_factory.View;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwingView implements View {
    private final List<PaintInstruction> paintInstructions = new CopyOnWriteArrayList<>();
    private final JFrame frame;

    public SwingView(int width, int height) {
        JComponent canvas = new JComponent() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D g = (Graphics2D) graphics;
                paintInstructions.forEach(p -> p.paint(g));
            }
        };
        canvas.setPreferredSize(new Dimension(width, height));

        frame = new JFrame();
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addPaintInstruction(PaintInstruction instruction) {
        paintInstructions.add(instruction);
        frame.repaint();
    }
}
