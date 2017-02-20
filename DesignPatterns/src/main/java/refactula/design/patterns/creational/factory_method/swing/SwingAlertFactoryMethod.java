package refactula.design.patterns.creational.factory_method.swing;

import refactula.design.patterns.creational.factory_method.Alert;
import refactula.design.patterns.creational.factory_method.AlertFactoryMethod;

public enum SwingAlertFactoryMethod implements AlertFactoryMethod {
    INSTANCE;

    @Override
    public Alert createAlert(String message) {
        return new SwingAlert(message);
    }

}
