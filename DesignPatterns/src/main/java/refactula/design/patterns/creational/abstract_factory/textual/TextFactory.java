package refactula.design.patterns.creational.abstract_factory.textual;

import refactula.design.patterns.creational.abstract_factory.AbstractFactory;
import refactula.design.patterns.creational.abstract_factory.CirclePainter;
import refactula.design.patterns.creational.abstract_factory.RectanglePainter;
import refactula.design.patterns.creational.abstract_factory.View;

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
