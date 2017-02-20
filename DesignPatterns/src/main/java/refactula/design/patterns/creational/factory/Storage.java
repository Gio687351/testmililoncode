package refactula.design.patterns.creational.factory;

public interface Storage {

    void store(String key, String value);

    String retrieve(String key);

}
