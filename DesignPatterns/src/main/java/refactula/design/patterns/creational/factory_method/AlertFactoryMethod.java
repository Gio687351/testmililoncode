package refactula.design.patterns.creational.factory_method;

import refactula.design.patterns.creational.factory_method.console.ConsoleAlertFactoryMethod;
import refactula.design.patterns.creational.factory_method.swing.SwingAlertFactoryMethod;

/**
 * Factory Method pattern - a class with a single method for creating object of some type.
 * Each implementation creates objects of different subtypes.
 *
 * @see ConsoleAlertFactoryMethod
 * @see SwingAlertFactoryMethod
 */
public interface AlertFactoryMethod {

    Alert createAlert(String message);

}
