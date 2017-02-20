package refactula.design.patterns.creational.factory_method.swing;

import refactula.design.patterns.creational.factory_method.Alert;

import javax.swing.JOptionPane;

public class SwingAlert implements Alert {
    private final String message;

    public SwingAlert(String message) {
        this.message = message;
    }

    @Override
    public void show() {
        JOptionPane.showMessageDialog(null,
                message,
                "Alert",
                JOptionPane.WARNING_MESSAGE);
    }
}
