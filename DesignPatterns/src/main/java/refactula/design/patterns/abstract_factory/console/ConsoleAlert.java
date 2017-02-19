package refactula.design.patterns.abstract_factory.console;

import refactula.design.patterns.abstract_factory.Alert;

public class ConsoleAlert implements Alert {
    private final String message;

    public ConsoleAlert(String message) {
        this.message = message;
    }

    @Override
    public void show() {
        System.out.println(message);
    }
}
