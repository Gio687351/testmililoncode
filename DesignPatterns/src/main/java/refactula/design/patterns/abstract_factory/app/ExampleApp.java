package refactula.design.patterns.abstract_factory.app;

import refactula.design.patterns.abstract_factory.AlertFactory;
import refactula.design.patterns.abstract_factory.console.ConsoleAlertFactory;
import refactula.design.patterns.abstract_factory.swing.SwingAlertFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleApp {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Are we going graphical? (y/n): ");
        String choice = in.readLine();
        AlertFactory factory = choice.equalsIgnoreCase("y") ? SwingAlertFactory.INSTANCE : ConsoleAlertFactory.INSTANCE;
        System.out.print("Enter a message to the world: ");
        String message = in.readLine();
        factory.createAlert(message).show();
        System.exit(0);
    }

}
