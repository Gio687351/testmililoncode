package refactula.design.patterns.abstract_factory.shapes;

import com.google.common.base.MoreObjects;

public class Rectangle {
    private final double lowerX;
    private final double lowerY;
    private final double upperX;
    private final double upperY;

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.lowerX = Math.min(x1, x2);
        this.lowerY = Math.min(y1, y2);
        this.upperX = Math.max(x1, x2);
        this.upperY = Math.max(y1, y2);
    }

    public double getLowerX() {
        return lowerX;
    }

    public double getLowerY() {
        return lowerY;
    }

    public double getUpperX() {
        return upperX;
    }

    public double getUpperY() {
        return upperY;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("lowerX", lowerX)
                .add("lowerY", lowerY)
                .add("upperX", upperX)
                .add("upperY", upperY)
                .toString();
    }

    public double getWidth() {
        return upperX - lowerX;
    }

    public double getHeight() {
        return upperY - lowerY;
    }
}
