package refactula.design.patterns.abstract_factory.swing;

import refactula.design.patterns.abstract_factory.Alert;
import refactula.design.patterns.abstract_factory.AlertFactory;

public enum  SwingAlertFactory implements AlertFactory {
    INSTANCE;

    @Override
    public Alert createAlert(String message) {
        return new SwingAlert(message);
    }

}
