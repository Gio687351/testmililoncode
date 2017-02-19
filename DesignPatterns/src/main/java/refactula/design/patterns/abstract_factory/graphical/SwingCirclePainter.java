package refactula.design.patterns.abstract_factory.graphical;

import refactula.design.patterns.abstract_factory.CirclePainter;
import refactula.design.patterns.abstract_factory.utils.CastUtils;
import refactula.design.patterns.abstract_factory.View;
import refactula.design.patterns.abstract_factory.shapes.Circle;

public class SwingCirclePainter implements CirclePainter {
    @Override
    public void paint(View view, Circle circle) {
        SwingView swingView = CastUtils.checkInstanceOf(SwingView.class, view);
        swingView.addPaintInstruction(g -> g.drawArc(
                (int) Math.round(circle.getLowerX()),
                (int) Math.round(circle.getLowerY()),
                (int) Math.round(circle.getDiameter()),
                (int) Math.round(circle.getDiameter()),
                0,
                360));
    }
}
