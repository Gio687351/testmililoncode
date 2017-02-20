package refactula.design.patterns.creational.factory_method.console;

import refactula.design.patterns.creational.factory_method.AlertFactoryMethod;

public enum ConsoleAlertFactoryMethod implements AlertFactoryMethod {
    INSTANCE;

    @Override
    public ConsoleAlert createAlert(String message) {
        return new ConsoleAlert(message);
    }

}
