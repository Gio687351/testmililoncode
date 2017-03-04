package refactula.story;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import static refactula.story.utils.Unchecked.unchecked;

public class ProgressBarPainter {
    private int width = 500;
    private int height = 20;
    private Color backgroundColor = new Color(226, 255, 167);
    private Color foregroundColor = new Color(13, 217, 0);

    public ProgressBarPainter setWidth(int width) {
        this.width = width;
        return this;
    }

    public ProgressBarPainter setHeight(int height) {
        this.height = height;
        return this;
    }

    public ProgressBarPainter setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public ProgressBarPainter setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        return this;
    }

    public void draw(double progress, File output) {
        int completedPx = (int) Math.round(width * progress);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, width, height);
        g.setColor(foregroundColor);
        g.fillRect(0, 0, completedPx, height);
        g.dispose();
        unchecked(() -> ImageIO.write(image, "png", output));
    }
}

