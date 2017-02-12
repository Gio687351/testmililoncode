package refactula.minecraft;

import com.google.common.base.Preconditions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class World {
    private final int chuckWidthX;
    private final int chunkHeight;
    private final int chuckWidthZ;

    private final WorldGenerator generator;
    private final Map<ChunkPosition, Chunk> chunks = new ConcurrentHashMap<>();

    public World(int chuckWidthX, int chunkHeight, int chuckWidthZ, WorldGenerator generator) {
        this.chuckWidthX = chuckWidthX;
        this.chunkHeight = chunkHeight;
        this.chuckWidthZ = chuckWidthZ;
        this.generator = generator;
    }

    public boolean isChunkInited(ChunkPosition chunkPosition) {
        return chunks.containsKey(chunkPosition);
    }

    public Chunk getInitedChunk(ChunkPosition chunkPosition) {
        Chunk chunk = chunks.get(chunkPosition);
        Preconditions.checkState(chunk != null, "Chunk %s is not initialized", chunkPosition);
        return chunk;
    }

    public Chunk getChunk(ChunkPosition chunkPosition) {
        initChunk(chunkPosition);
        return getInitedChunk(chunkPosition);
    }

    public void initChunk(ChunkPosition chunkPosition) {
        if (isChunkInited(chunkPosition)) {
            return;
        }
        Chunk chunk = new Chunk(chuckWidthX, chunkHeight, chuckWidthZ);
        for (int x = 0; x < chunk.getWidthX(); x++) {
            for (int y = 0; y < chunk.getHeight(); y++) {
                for (int z = 0; z < chunk.getWidthZ(); z++) {
                    int globalX = chunkPosition.getX() * chuckWidthX + x;
                    int globalZ = chunkPosition.getZ() * chuckWidthZ + z;
                    Block block = generator.getBlockOn(globalX, y, globalZ);
                    chunk.set(x, y, z, block);
                }
            }
        }
        chunks.put(chunkPosition, chunk);
    }
}
