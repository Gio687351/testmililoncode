package refactula.design.patterns.factory;

public interface Storage {

    void store(String key, String value);

    String retrieve(String key);

}
