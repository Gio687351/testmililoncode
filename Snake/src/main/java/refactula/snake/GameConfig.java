package refactula.snake;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class GameConfig {
    private final int columns;
    private final int rows;
    private final ImmutableList<Cell> initialSnakeCells;
    private final MoveDirection initialSnakeMoveDirection;

    private GameConfig(
            int columns,
            int rows,
            ImmutableList<Cell> initialSnakeCells,
            MoveDirection initialSnakeMoveDirection) {

        this.columns = columns;
        this.rows = rows;
        this.initialSnakeCells = initialSnakeCells;
        this.initialSnakeMoveDirection = initialSnakeMoveDirection;
    }

    public int columns() {
        return columns;
    }

    public int rows() {
        return rows;
    }

    public List<Cell> getInitialSnakeCells() {
        return initialSnakeCells;
    }

    public MoveDirection getInitialSnakeMoveDirection() {
        return initialSnakeMoveDirection;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer columns;
        private Integer rows;
        private ImmutableList<Cell> initialSnakeCells;
        private MoveDirection initialSnakeMoveDirection;

        private Builder() {}

        public Builder setColumns(Integer columns) {
            this.columns = columns;
            return this;
        }

        public Builder setRows(Integer rows) {
            this.rows = rows;
            return this;
        }

        public Builder setInitialSnakeCells(ImmutableList<Cell> initialSnakeCells) {
            this.initialSnakeCells = initialSnakeCells;
            return this;
        }

        public Builder setInitialSnakeMoveDirection(MoveDirection initialSnakeMoveDirection) {
            this.initialSnakeMoveDirection = initialSnakeMoveDirection;
            return this;
        }

        public GameConfig build() {
            return new GameConfig(
                    Preconditions.checkNotNull(columns),
                    Preconditions.checkNotNull(rows),
                    Preconditions.checkNotNull(initialSnakeCells),
                    Preconditions.checkNotNull(initialSnakeMoveDirection));
        }
    }
}
