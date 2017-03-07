package refactula.design.patterns.behavioral.mediator.shape;

public class Circle implements Shape {
    private final float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }
}
