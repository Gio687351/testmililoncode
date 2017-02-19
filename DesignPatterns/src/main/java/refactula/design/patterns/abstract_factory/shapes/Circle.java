package refactula.design.patterns.abstract_factory.shapes;

import com.google.common.base.MoreObjects;

public class Circle {
    private final double centerX;
    private final double centerY;
    private final double radius;

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("centerX", centerX)
                .add("centerY", centerY)
                .add("radius", radius)
                .toString();
    }

    public double getLowerX() {
        return centerX - radius;
    }

    public double getLowerY() {
        return centerY - radius;
    }

    public double getDiameter() {
        return radius * 2.0;
    }
}
