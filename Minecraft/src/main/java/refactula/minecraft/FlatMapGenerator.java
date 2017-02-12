package refactula.minecraft;

public class FlatMapGenerator implements WorldGenerator {

    @Override
    public Block getBlockOn(long globalX, long globalY, long globalZ) {
        if (globalY == 0) {
            return Blocks.BEDROCK;
        } else if (globalY > 0 && globalY < 80) {
            return Blocks.DIRT;
        } else if (globalY == 80) {
            return Blocks.GRASS;
        } else  {
            return Blocks.AIR;
        }
    }

}
