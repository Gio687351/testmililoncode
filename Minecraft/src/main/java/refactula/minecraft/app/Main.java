package refactula.minecraft.app;

import refactula.minecraft.Block;
import refactula.minecraft.Chunk;
import refactula.minecraft.ChunkPosition;
import refactula.minecraft.FlatMapGenerator;
import refactula.minecraft.World;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Main {

    public static void main(String[] args) {
        World world = new World(16, 100, 16, new FlatMapGenerator());
        Chunk chunk = world.getChunk(new ChunkPosition(10, 10));

        int viewScale = 3;
        int scaleX = 2;
        int scaleY = 2;
        int scaleZ = 1;
        JComponent canvas = new JComponent() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D g = (Graphics2D) graphics;
                g.scale(viewScale, viewScale);
                int width = getWidth() / viewScale;
                int height = getHeight() / viewScale;
                int drawingHeight = chunk.getHeight() * scaleY + chunk.getWidthZ() * scaleZ;
                int drawingWidth = chunk.getWidthX() * scaleX + chunk.getWidthZ() * scaleZ;
                int offsetX = (width - drawingWidth) / 2;
                int offsetY = (height - drawingHeight) / 2;

                for (int z = 0; z < chunk.getWidthZ(); z++) {
                    for (int x = 0; x < chunk.getWidthX(); x++) {
                        for (int y = chunk.getHeight() - 1; y >= 0; y--) {
                            Block block = chunk.get(x, y, z);
                            g.setColor(block.getColor());
                            g.fillRect(
                                    offsetX + x * scaleX + z * scaleZ,
                                    height - (offsetY + chunk.getWidthZ() + y * scaleY - z * scaleZ),
                                    scaleX,
                                    scaleY);
                        }
                    }
                }
            }
        };
        canvas.setPreferredSize(new Dimension(
                (chunk.getWidthX() * scaleX + 50) * viewScale,
                (chunk.getHeight() * scaleY + 50) * viewScale));

        JFrame frame = new JFrame();
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
