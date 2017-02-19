package refactula.design.patterns.factory;

import refactula.design.patterns.factory.Storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryStorage implements Storage {
    private final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    @Override
    public void store(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String retrieve(String key) {
        return map.get(key);
    }
}
