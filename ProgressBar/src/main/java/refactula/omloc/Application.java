package refactula.omloc;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {

    public static final String PROGRESS_URL =
            "https://raw.githubusercontent.com/Refactula/1MLoC/master/ProgressBar/export/Progress.png";

    public static void main(String[] args) throws Exception {
        int goalLines = 1000000;
        String workingDir = System.getProperty("user.dir");
        int lines = countLines(Paths.get(workingDir));

        double progress = Math.min(1, 1d * lines / goalLines);
        String progressInPercents = String.format("%.2f%%", progress * 100.0);

        int barWidth = 500;
        int barHeight = 50;
        int completedPx = (int) Math.round(barWidth * progress);
        BufferedImage image = new BufferedImage(barWidth, barHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(226, 255, 167));
        g.fillRect(0, 0, barWidth, barHeight);
        g.setColor(new Color(13, 217, 0));
        g.fillRect(0, 0, completedPx, barHeight);
        g.dispose();

        ImageIO.write(image, "png", Paths.get(workingDir, "ProgressBar", "export", "Progress.png").toFile());

        Path readme = Paths.get(Application.class.getClassLoader().getResource("README.md").toURI());
        Files.write(Paths.get(workingDir, "README.md"), Files.lines(readme)
                .map(replace("%progress%", progressInPercents))
                .map(replace("%lines%", lines))
                .map(replace("%progress_url%", PROGRESS_URL))
                .collect(Collectors.toList()));
    }

    private static Function<String, String> replace(String pattern, Object value) {
        return s -> s.replaceAll(pattern, String.valueOf(value));
    }

    private static int countLines(Path rootPath) {
        return uncheckedIO(() -> Files.walk(rootPath)
                .filter(p -> p.toString().endsWith(".java"))
                .mapToInt(Application::countFileLines)
                .reduce(0, (x, y) -> x + y));
    }

    private static int countFileLines(Path path) {
        return uncheckedIO(() -> Files.lines(path)
                .filter(l -> !l.isEmpty())
                .mapToInt(l -> 1)
                .reduce(0, (x, y) -> x + y));
    }

    private static <T> T uncheckedIO(IoOperation<T> ioOperation) {
        try {
            return ioOperation.perform();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private interface IoOperation<T> {
        T perform() throws IOException;
    }

    private static void display(Image image) {
        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)), "Image", JOptionPane.PLAIN_MESSAGE, null);
    }

}
