package refactula.story;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Bindings {
    private final Map<String, String> map = new HashMap<>();

    public void bind(String key, Object value) {
        map.put(key, String.valueOf(value));
    }

    public String enhance(String s) {
        String enhanced = s;
        for (Entry<String, String> entry : map.entrySet()) {
            enhanced = enhanced.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        return enhanced;
    }
}
