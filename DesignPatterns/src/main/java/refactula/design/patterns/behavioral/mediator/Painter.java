package refactula.design.patterns.behavioral.mediator;

import refactula.design.patterns.behavioral.mediator.shape.Shape;

import java.awt.Color;

public interface Painter {

    void draw(float x, float y, Shape shape, Color color);

}
