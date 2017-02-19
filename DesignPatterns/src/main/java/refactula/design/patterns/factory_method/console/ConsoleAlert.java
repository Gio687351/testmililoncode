package refactula.design.patterns.factory_method.console;

import refactula.design.patterns.factory_method.Alert;

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
