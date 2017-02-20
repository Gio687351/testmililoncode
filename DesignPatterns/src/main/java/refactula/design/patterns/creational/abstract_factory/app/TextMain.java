package refactula.design.patterns.creational.abstract_factory.app;

import refactula.design.patterns.creational.abstract_factory.textual.TextFactory;

public class TextMain {

    public static void main(String[] args) {
        Application.create(new TextFactory()).run();
    }
    
}
