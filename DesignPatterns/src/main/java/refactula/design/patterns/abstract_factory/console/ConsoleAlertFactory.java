package refactula.design.patterns.abstract_factory.console;

import refactula.design.patterns.abstract_factory.AlertFactory;

public enum ConsoleAlertFactory implements AlertFactory {
    INSTANCE;

    @Override
    public ConsoleAlert createAlert(String message) {
        return new ConsoleAlert(message);
    }

}
