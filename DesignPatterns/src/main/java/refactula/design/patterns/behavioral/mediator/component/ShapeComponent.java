package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.shape.Shape;

public class ShapeComponent extends CreatureComponent {
    private final Shape shape;

    public ShapeComponent(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }
}
