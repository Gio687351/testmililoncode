package refactula.design.patterns.factory_method;

/**
 * Factory Method pattern - a class with a single method for creating object of some type.
 * Each implementation creates objects of different subtypes.
 *
 * @see refactula.design.patterns.factory_method.console.ConsoleAlertFactoryMethod
 * @see refactula.design.patterns.factory_method.swing.SwingAlertFactoryMethod
 */
public interface AlertFactoryMethod {

    Alert createAlert(String message);

}
