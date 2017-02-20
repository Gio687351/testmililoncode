package refactula.design.patterns.creational.abstract_factory.app;

import refactula.design.patterns.creational.abstract_factory.graphical.SwingFactory;

public class SwingMain {

    public static void main(String[] args) {
        Application.create(new SwingFactory(350, 350)).run();
    }

}
