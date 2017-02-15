package refactula.snake;

import com.google.common.base.Preconditions;

import java.awt.Color;

public class ViewConfig {
    private final int columns;
    private final int rows;
    private final int cellWidthPx;
    private final int cellHeightPx;
    private final Color backgroundColor;
    private final Color color;

    public ViewConfig(
            int columns,
            int rows,
            int cellWidthPx,
            int cellHeightPx,
            Color backgroundColor,
            Color color) {

        this.columns = columns;
        this.rows = rows;
        this.cellWidthPx = cellWidthPx;
        this.cellHeightPx = cellHeightPx;
        this.backgroundColor = backgroundColor;
        this.color = color;
    }

    public int columns() {
        return columns;
    }

    public int rows() {
        return rows;
    }

    public int getCellWidthPx() {
        return cellWidthPx;
    }

    public int getCellHeightPx() {
        return cellHeightPx;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getColor() {
        return color;
    }

    public int getViewWidthPx() {
        return columns * cellWidthPx;
    }

    public int getViewHeightPx() {
        return rows * cellHeightPx;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer columns;
        private Integer rows;
        private Integer cellWidthPx;
        private Integer cellHeightPx;
        private Color backgroundColor;
        private Color color;

        private Builder() {
        }

        public Builder setColumns(Integer columns) {
            this.columns = columns;
            return this;
        }

        public Builder setRows(Integer rows) {
            this.rows = rows;
            return this;
        }

        public Builder setCellWidthPx(Integer cellWidthPx) {
            this.cellWidthPx = cellWidthPx;
            return this;
        }

        public Builder setCellHeightPx(Integer cellHeightPx) {
            this.cellHeightPx = cellHeightPx;
            return this;
        }

        public Builder setBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        public ViewConfig build() {
            return new ViewConfig(
                    Preconditions.checkNotNull(columns),
                    Preconditions.checkNotNull(rows),
                    Preconditions.checkNotNull(cellWidthPx),
                    Preconditions.checkNotNull(cellHeightPx),
                    Preconditions.checkNotNull(backgroundColor),
                    Preconditions.checkNotNull(color));
        }
    }

}
