package refactula.design.patterns.abstract_factory.textual;

import refactula.design.patterns.abstract_factory.RectanglePainter;
import refactula.design.patterns.abstract_factory.utils.CastUtils;
import refactula.design.patterns.abstract_factory.View;
import refactula.design.patterns.abstract_factory.shapes.Rectangle;

public class TextRectanglePainter implements RectanglePainter {

    @Override
    public void paint(View view, Rectangle rectangle) {
        TextView textView = CastUtils.checkInstanceOf(TextView.class, view);
        textView.println(rectangle.toString());
    }

}
