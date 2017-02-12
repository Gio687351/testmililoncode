package refactula.minecraft;

public class Chunk {
    private final int widthX;
    private final int height;
    private final int widthZ;

    private final Block[][][] blocks;

    public Chunk(int widthX, int height, int widthZ) {
        this.widthX = widthX;
        this.height = height;
        this.widthZ = widthZ;
        this.blocks = new Block[widthX][height][widthZ];
        for (int x = 0; x < widthX; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < widthZ; z++) {
                    blocks[x][y][z] = Blocks.AIR;
                }
            }
        }
    }

    public int getWidthX() {
        return widthX;
    }

    public int getHeight() {
        return height;
    }

    public int getWidthZ() {
        return widthZ;
    }

    public Block get(int x, int y, int z) {
        return blocks[x][y][z];
    }

    public void set(int x, int y, int z, Block block) {
        blocks[x][y][z] = block;
    }
}
