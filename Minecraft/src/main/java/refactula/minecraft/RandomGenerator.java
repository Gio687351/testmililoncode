package refactula.minecraft;

import java.util.List;
import java.util.Random;

public class RandomGenerator implements WorldGenerator {
    private final Random random;
    private final List<Block> blockList;

    public RandomGenerator(Random random, List<Block> blockList) {
        this.random = random;
        this.blockList = blockList;
    }

    @Override
    public Block getBlockOn(long globalX, long globalY, long globalZ) {
        return blockList.get(random.nextInt(blockList.size()));
    }
}
