package refactula.design.patterns.creational.abstract_factory;

public interface AbstractFactory {

    View createView();

    CirclePainter createCirclePainter();

    RectanglePainter createRectanglePainter();

}
