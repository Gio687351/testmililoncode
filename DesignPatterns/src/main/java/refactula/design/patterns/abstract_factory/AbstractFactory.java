package refactula.design.patterns.abstract_factory;

public interface AbstractFactory {

    View createView();

    CirclePainter createCirclePainter();

    RectanglePainter createRectanglePainter();

}
