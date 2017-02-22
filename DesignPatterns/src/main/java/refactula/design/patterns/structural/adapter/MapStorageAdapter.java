package refactula.design.patterns.structural.adapter;

import java.util.Map;

public class MapStorageAdapter implements Storage {
    private final Map<String, String> map;

    public MapStorageAdapter(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void store(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public int size() {
        return map.size();
    }
}
