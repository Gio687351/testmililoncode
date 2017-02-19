package refactula.design.patterns.factory_method.app;

import refactula.design.patterns.factory_method.AlertFactoryMethod;
import refactula.design.patterns.factory_method.console.ConsoleAlertFactoryMethod;
import refactula.design.patterns.factory_method.swing.SwingAlertFactoryMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleApp {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Are we going graphical? (y/n): ");
        String choice = in.readLine();
        AlertFactoryMethod factory = choice.equalsIgnoreCase("y") ? SwingAlertFactoryMethod.INSTANCE : ConsoleAlertFactoryMethod.INSTANCE;
        System.out.print("Enter a message to the world: ");
        String message = in.readLine();
        factory.createAlert(message).show();
        System.exit(0);
    }

}
