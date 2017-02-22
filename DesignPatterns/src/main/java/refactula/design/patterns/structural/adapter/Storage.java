package refactula.design.patterns.structural.adapter;

public interface Storage {

    void store(String key, String value);

    String get(String key);

    int size();

}
