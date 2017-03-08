package refactula.design.patterns.behavioral.mediator;

import com.google.common.base.Preconditions;
import refactula.design.patterns.behavioral.mediator.shape.Circle;
import refactula.design.patterns.behavioral.mediator.shape.Shape;

import java.awt.Color;
import java.awt.Graphics2D;

public class GraphicsPainter implements Painter {
    private final Graphics2D g;

    public GraphicsPainter(Graphics2D g) {
        this.g = g;
    }

    @Override
    public void draw(float x, float y, Shape shape, Color color) {
        Preconditions.checkArgument(shape instanceof Circle);
        Circle circle = (Circle) shape;
        float r = circle.getRadius();
        g.setColor(color);
        g.fillArc(Math.round(x - r),
                Math.round(y - r),
                Math.round(r * 2),
                Math.round(r * 2),
                0,
                360);
    }
}
