package refactula.snake;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class SnakeGameConfig {
    private final int columns;
    private final int rows;
    private final ImmutableList<Cell> initialSnakeCells;
    private final MoveDirection initialSnakeMoveDirection;
    private final int initialRabbitColumn;
    private final int initialRabbitRow;

    private SnakeGameConfig(
            int columns,
            int rows,
            ImmutableList<Cell> initialSnakeCells,
            MoveDirection initialSnakeMoveDirection,
            int initialRabbitColumn,
            int initialRabbitRow) {

        this.columns = columns;
        this.rows = rows;
        this.initialSnakeCells = initialSnakeCells;
        this.initialSnakeMoveDirection = initialSnakeMoveDirection;
        this.initialRabbitColumn = initialRabbitColumn;
        this.initialRabbitRow = initialRabbitRow;
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

    public int getInitialRabbitColumn() {
        return initialRabbitColumn;
    }

    public int getInitialRabbitRow() {
        return initialRabbitRow;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Integer columns;
        private Integer rows;
        private ImmutableList<Cell> initialSnakeCells;
        private MoveDirection initialSnakeMoveDirection;
        private Integer initialRabbitColumn;
        private Integer initialRabbitRow;

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

        public Builder setInitialRabbitColumn(Integer initialRabbitColumn) {
            this.initialRabbitColumn = initialRabbitColumn;
            return this;
        }

        public Builder setInitialRabbitRow(Integer initialRabbitRow) {
            this.initialRabbitRow = initialRabbitRow;
            return this;
        }

        public SnakeGameConfig build() {
            return new SnakeGameConfig(
                    Preconditions.checkNotNull(columns),
                    Preconditions.checkNotNull(rows),
                    Preconditions.checkNotNull(initialSnakeCells),
                    Preconditions.checkNotNull(initialSnakeMoveDirection),
                    Preconditions.checkNotNull(initialRabbitColumn),
                    Preconditions.checkNotNull(initialRabbitRow));
        }
    }
}
