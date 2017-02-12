package refactula.minecraft.app;

import com.google.common.collect.ImmutableList;
import refactula.minecraft.Block;
import refactula.minecraft.Blocks;
import refactula.minecraft.Chunk;
import refactula.minecraft.ChunkPosition;
import refactula.minecraft.FlatMapGenerator;
import refactula.minecraft.RandomGenerator;
import refactula.minecraft.World;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        RandomGenerator randomGenerator = new RandomGenerator(
                new Random(),
                ImmutableList.copyOf(Blocks.values()));
        World world = new World(16, 100, 16, new FlatMapGenerator());
        Chunk chunk = world.getChunk(new ChunkPosition(10, 10));

        int scale = 3;
        int xSize = 2;
        int ySize = 2;
        int zSize = 1;
        JComponent canvas = new JComponent() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D g = (Graphics2D) graphics;
                g.scale(scale, scale);
                int width = getWidth() / scale;
                int height = getHeight() / scale;
                int drawingHeight = chunk.getHeight() * ySize + chunk.getWidthZ() * zSize;
                int drawingWidth = chunk.getWidthX() * xSize + chunk.getWidthZ() * zSize;
                int offsetX = (width - drawingWidth) / 2;
                int offsetY = (height - drawingHeight) / 2;

                for (int z = 0; z < chunk.getWidthZ(); z++) {
                    for (int x = 0; x < chunk.getWidthX(); x++) {
                        for (int y = chunk.getHeight() - 1; y >= 0; y--) {
                            Block block = chunk.get(x, y, z);
                            g.setColor(block.getColor());
                            g.fillRect(
                                    offsetX + x * xSize + z * zSize,
                                    height - (offsetY + chunk.getWidthZ() + y * ySize - z * zSize),
                                    xSize,
                                    ySize);
                        }
                    }
                }
            }
        };
        canvas.setPreferredSize(new Dimension(
                (chunk.getWidthX() * xSize + 50) * scale,
                (chunk.getHeight() * ySize + 50) * scale));

        JFrame frame = new JFrame();
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
