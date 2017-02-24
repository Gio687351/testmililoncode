package refactula.omloc;

import com.google.common.base.Preconditions;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
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
            "ProgressBar/export/Progress.png";

    public static void main(String[] args) throws Exception {
        int goalLoC = 1000000;
        String workingDir = System.getProperty("user.dir");
        int lines = countLines(Paths.get(workingDir));

        int firstLevelLoC = 100;
        int nextLevelLoC = 200;
        int levels = 100;
        Preconditions.checkState(getLoCAfterCompleted(levels, firstLevelLoC, nextLevelLoC) == goalLoC);

        int level = 0;
        while (getLoCAfterCompleted(level, firstLevelLoC, nextLevelLoC) <= lines) {
            level++;
        }

        int completedLines = lines - getLoCBeforeCompleted(level, firstLevelLoC, nextLevelLoC);
        int levelLines = getLoCToComplete(level, firstLevelLoC, nextLevelLoC);
        double progress = 1.0 * completedLines / levelLines;
        String progressString = String.format("%.2f%%", progress * 100.0);

        int barWidth = 500;
        int barHeight = 20;
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
                .map(replace("%name%", "Refactula"))
                .map(replace("%level%", level))
                .map(replace("%progress%", progressString))
                .map(replace("%completed_lines%", completedLines))
                .map(replace("%level_lines%", levelLines))
                .map(replace("%lines_of_code%", lines))
                .map(replace("%progress_url%", PROGRESS_URL))
                .collect(Collectors.toList()));
    }

    protected static int getLoCAfterCompleted(int level, int firstLevelLoC, int nextLevelLoC) {
        return level * firstLevelLoC + (level - 1) * level * nextLevelLoC / 2;
    }

    protected static int getLoCBeforeCompleted(int level, int firstLevelLoC, int nextLevelLoC) {
        return getLoCAfterCompleted(level - 1, firstLevelLoC, nextLevelLoC);
    }

    protected static int getLoCToComplete(int level, int firstLevelLoC, int nextLevelLoC) {
        return getLoCAfterCompleted(level, firstLevelLoC, nextLevelLoC) -
                getLoCBeforeCompleted(level, firstLevelLoC, nextLevelLoC);
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

}
