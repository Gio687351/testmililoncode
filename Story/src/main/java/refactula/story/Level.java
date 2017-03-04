package refactula.story;

import com.google.common.base.Preconditions;

public class Level {
    private final int level;
    private final int completed;
    private final int lines;

    public Level(int level, int completed, int lines) {
        Preconditions.checkArgument(completed < lines);
        this.level = level;
        this.completed = completed;
        this.lines = lines;
    }

    public int getLevel() {
        return level;
    }

    public int getCompleted() {
        return completed;
    }

    public int getLines() {
        return lines;
    }

    public double getProgress() {
        return 100.0 * completed / lines;
    }
}
