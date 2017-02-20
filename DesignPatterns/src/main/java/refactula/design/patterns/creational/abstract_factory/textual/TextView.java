package refactula.design.patterns.creational.abstract_factory.textual;

import refactula.design.patterns.creational.abstract_factory.View;

public class TextView implements View {

    public void println(String s) {
        System.out.println(s);
    }

}
