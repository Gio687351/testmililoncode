package refactula.design.patterns.factory_method.swing;

import refactula.design.patterns.factory_method.Alert;
import refactula.design.patterns.factory_method.AlertFactoryMethod;

public enum SwingAlertFactoryMethod implements AlertFactoryMethod {
    INSTANCE;

    @Override
    public Alert createAlert(String message) {
        return new SwingAlert(message);
    }

}
