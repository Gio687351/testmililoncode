package refactula.minecraft;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class World {
    private final Map<ChunkPosition, Chunk> chunks = new ConcurrentHashMap<>();

    public void addChuck(ChunkPosition position, Chunk chunk) {
        chunks.put(position, chunk);
    }
}
