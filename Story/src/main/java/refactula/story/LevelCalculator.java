package refactula.story;

public class LevelCalculator {
    private final int firstLevel;
    private final int nextLevelAddition;

    public LevelCalculator(int firstLevel, int nextLevelAddition) {
        this.firstLevel = firstLevel;
        this.nextLevelAddition = nextLevelAddition;
    }

    public int getLinesAfterCompleted(int level) {
        return level * firstLevel + (level - 1) * level * nextLevelAddition / 2;
    }

    public int getLinesBeforeCompleted(int level) {
        return getLinesAfterCompleted(level - 1);
    }

    public int getLinesToComplete(int level) {
        return getLinesAfterCompleted(level) - getLinesBeforeCompleted(level);
    }

    public int getLevel(int lines) {
        int level = 0;
        while (getLinesAfterCompleted(level) <= lines) {
            level++;
        }
        return level;
    }

    public Progress getProgress(int linesOfCode) {
        int level = getLevel(linesOfCode);
        return new Progress(level, linesOfCode - getLinesBeforeCompleted(level), getLinesToComplete(level));
    }

}
