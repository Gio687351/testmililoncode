package refactula.design.patterns.abstract_factory.app;

import refactula.design.patterns.abstract_factory.textual.TextFactory;

public class TextMain {

    public static void main(String[] args) {
        Application.create(new TextFactory()).run();
    }
    
}
