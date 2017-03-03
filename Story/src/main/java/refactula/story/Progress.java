package refactula.story;

public class Progress {
    private final int level;
    private final int completedLines;
    private final int linesToComplete;

    public Progress(int level, int completedLines, int linesToComplete) {
        this.level = level;
        this.completedLines = completedLines;
        this.linesToComplete = linesToComplete;
    }

    public int getLevel() {
        return level;
    }

    public int getCompletedLines() {
        return completedLines;
    }

    public int getLinesToComplete() {
        return linesToComplete;
    }

    public double getProgressInPersents() {
        return completedLines * 100 * 100 / linesToComplete / 100.0;
    }

    @Override
    public String toString() {
        return "level=" + level +
                ", progress=" + getProgressInPersents() + "%" +
                " (" + completedLines +
                " / " + linesToComplete +
                ')';
    }

    public Bindings bind(Bindings bindings) {
        bindings.bind("level", getLevel());
        bindings.bind("level.progress", String.format("%.2f%%", getProgressInPersents()));
        bindings.bind("level.completed", getCompletedLines());
        bindings.bind("level.lines", getLinesToComplete());
        return bindings;
    }
}
