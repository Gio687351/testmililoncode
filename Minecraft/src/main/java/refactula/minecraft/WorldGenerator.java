package refactula.minecraft;

public interface WorldGenerator {

    Block getBlockOn(long globalX, long globalY, long globalZ);

}
