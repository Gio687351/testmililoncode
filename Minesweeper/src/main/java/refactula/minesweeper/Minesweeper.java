package refactula.minesweeper;

import com.google.common.base.Preconditions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Minesweeper {
    private static final int MINE = -1;

    private final int width;
    private final int height;
    private final int minesAmount;
    private final Random random;

    private final int[][] field;
    private final boolean[][] opened;

    private boolean isInitialized = false;
    private boolean isGameLost = false;
    private int hidden;

    public Minesweeper(int width, int height, int minesAmount, Random random) {
        Preconditions.checkArgument(minesAmount > 0);
        Preconditions.checkArgument(width > 0);
        Preconditions.checkArgument(height > 0);
        Preconditions.checkArgument(minesAmount < width * height);
        this.width = width;
        this.height = height;
        this.minesAmount = minesAmount;
        this.random = Preconditions.checkNotNull(random);
        this.field = new int[width][height];
        this.opened = new boolean[width][height];
        this.hidden = width * height;
    }

    public void open(int x, int y) {
        Preconditions.checkState(!isGameOver());
        Preconditions.checkState(!opened[x][y]);
        doOpen(x, y);
        if (!isInitialized) {
            initialize();
            isInitialized = true;
        }
        if (isMine(x, y)) {
            isGameLost = true;
            return;
        }
        int minesAround = getMinesAround(x, y);
        if (minesAround == 0) {
            Queue<Integer> queueX = new LinkedList<>();
            Queue<Integer> queueY = new LinkedList<>();
            queueX.add(x);
            queueY.add(y);
            while (!queueX.isEmpty()) {
                int qx = queueX.poll();
                int qy = queueY.poll();
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int nx = qx + dx;
                        int ny = qy + dy;
                        if (isInsideField(nx, ny) && !isOpened(nx, ny)) {
                            doOpen(nx, ny);
                            if (!isMine(nx, ny) && getMinesAround(nx, ny) == 0) {
                                queueX.add(nx);
                                queueY.add(ny);
                            }
                        }
                    }
                }
            }
        }
    }

    private void doOpen(int x, int y) {
        opened[x][y] = true;
        hidden--;
    }

    private void initialize() {
        int minesLeft = minesAmount;
        while (minesLeft > 0) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            if (!isMine(x, y) && !isOpened(x, y)) {
                field[x][y] = MINE;
                minesLeft--;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int nx = x + dx;
                        int ny = y + dy;
                        if (isInsideField(nx, ny) && !isMine(nx, ny)) {
                            field[nx][ny]++;
                        }
                    }
                }
            }
        }
    }

    private boolean isInsideField(int x, int y) {
        return 0 <= x && x < width && 0 <= y && y < height;
    }

    public boolean isOpened(int x, int y) {
        return isWin() || opened[x][y];
    }

    public boolean isMine(int x, int y) {
        return field[x][y] == MINE;
    }

    public int getMinesAround(int x, int y) {
        int minesAround = field[x][y];
        Preconditions.checkState(minesAround != MINE);
        return minesAround;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isGameLost() {
        return isGameLost;
    }

    public boolean isWin() {
        return !isGameLost && hidden == minesAmount;
    }

    public boolean isGameOver() {
        return isGameLost() || isWin();
    }
}
