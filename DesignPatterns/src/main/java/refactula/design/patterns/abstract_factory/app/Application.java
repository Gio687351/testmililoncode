package refactula.design.patterns.abstract_factory.app;

import refactula.design.patterns.abstract_factory.AbstractFactory;
import refactula.design.patterns.abstract_factory.CirclePainter;
import refactula.design.patterns.abstract_factory.RectanglePainter;
import refactula.design.patterns.abstract_factory.View;
import refactula.design.patterns.abstract_factory.shapes.Circle;
import refactula.design.patterns.abstract_factory.shapes.Rectangle;

public class Application {
    private final View view;
    private final CirclePainter circlePainter;
    private final RectanglePainter rectanglePainter;

    public static Application create(AbstractFactory factory) {
        return new Application(
                factory.createView(),
                factory.createCirclePainter(),
                factory.createRectanglePainter());
    }

    public Application(
            View view,
            CirclePainter circlePainter,
            RectanglePainter rectanglePainter) {

        this.view = view;
        this.circlePainter = circlePainter;
        this.rectanglePainter = rectanglePainter;
    }

    public void run() {
        circlePainter.paint(view, new Circle(100, 100, 50));
        rectanglePainter.paint(view, new Rectangle(100, 100, 300, 300));
    }
}
