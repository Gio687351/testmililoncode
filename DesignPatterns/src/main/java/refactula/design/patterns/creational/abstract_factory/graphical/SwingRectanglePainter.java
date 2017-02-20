package refactula.design.patterns.creational.abstract_factory.graphical;

import refactula.design.patterns.creational.abstract_factory.RectanglePainter;
import refactula.design.patterns.creational.abstract_factory.utils.CastUtils;
import refactula.design.patterns.creational.abstract_factory.View;
import refactula.design.patterns.creational.abstract_factory.shapes.Rectangle;

public class SwingRectanglePainter implements RectanglePainter {
    @Override
    public void paint(View view, Rectangle rectangle) {
        SwingView swingView = CastUtils.checkInstanceOf(SwingView.class, view);
        swingView.addPaintInstruction(g -> g.drawRect(
                (int) Math.round(rectangle.getLowerX()),
                (int) Math.round(rectangle.getLowerY()),
                (int) Math.round(rectangle.getWidth()),
                (int) Math.round(rectangle.getHeight())));
    }
}
