package refactula.design.patterns.behavioral.mediator.component;

import refactula.design.patterns.behavioral.mediator.Painter;

import java.awt.Color;

public class PainterComponent extends CreatureComponent {
    private final Color color;

    public PainterComponent(Color color) {
        this.color = color;
    }

    public void draw(Painter painter) {
        painter.draw(mediator().getX(), mediator().getY(), mediator().getShape(), color);
    }
}
