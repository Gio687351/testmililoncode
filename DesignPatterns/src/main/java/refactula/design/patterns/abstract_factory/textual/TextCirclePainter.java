package refactula.design.patterns.abstract_factory.textual;

import refactula.design.patterns.abstract_factory.CirclePainter;
import refactula.design.patterns.abstract_factory.utils.CastUtils;
import refactula.design.patterns.abstract_factory.View;
import refactula.design.patterns.abstract_factory.shapes.Circle;

public class TextCirclePainter implements CirclePainter {

    @Override
    public void paint(View view, Circle circle) {
        TextView textView = CastUtils.checkInstanceOf(TextView.class, view);
        textView.println(circle.toString());
    }

}
