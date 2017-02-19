package refactula.design.patterns.abstract_factory.textual;

import refactula.design.patterns.abstract_factory.AbstractFactory;
import refactula.design.patterns.abstract_factory.CirclePainter;
import refactula.design.patterns.abstract_factory.RectanglePainter;
import refactula.design.patterns.abstract_factory.View;

public class TextFactory implements AbstractFactory {

    @Override
    public View createView() {
        return new TextView();
    }

    @Override
    public CirclePainter createCirclePainter() {
        return new TextCirclePainter();
    }

    @Override
    public RectanglePainter createRectanglePainter() {
        return new TextRectanglePainter();
    }

}
