package refactula.design.patterns.abstract_factory.graphical;

import refactula.design.patterns.abstract_factory.AbstractFactory;
import refactula.design.patterns.abstract_factory.CirclePainter;
import refactula.design.patterns.abstract_factory.RectanglePainter;
import refactula.design.patterns.abstract_factory.View;

public class SwingFactory implements AbstractFactory {
    private final int viewWidth;
    private final int viewHeight;

    public SwingFactory(int viewWidth, int viewHeight) {
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }

    @Override
    public View createView() {
        return new SwingView(viewWidth, viewHeight);
    }

    @Override
    public CirclePainter createCirclePainter() {
        return new SwingCirclePainter();
    }

    @Override
    public RectanglePainter createRectanglePainter() {
        return new SwingRectanglePainter();
    }
}
