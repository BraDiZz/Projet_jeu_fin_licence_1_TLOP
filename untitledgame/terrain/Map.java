package untitledgame.terrain;

import untitledgame.terrain.Chunk;
import untitledgame.personnages.*;
import untitledgame.texture.*;

public class Map {
    private Chunk[][] map;
    private int sizeX;
    private int sizeY;
    private long seed;
    public static int curChunkX = 0;
    public static int curChunkY = 0;

    public Map(int sizeX, int sizeY, long seed) {
        map = new Chunk[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.seed = seed;
        populateMap(seed);
    }

    public Map() {
        this(4, 4, 99999l);
    }

    private void populateMap(long seed) {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                map[x][y] = new Chunk(x, y);
                map[x][y].addFeatures(new Texture(TexturePath.TREE), 6);
                map[x][y].addFeatures(new Texture(TexturePath.ROCK), 2);
                map[x][y].addFeatures(new Texture(TexturePath.BUSHES), 3);
                map[x][y].perlinize(seed * 14894465l, 18, new Texture(TexturePath.GRASS1));
                map[x][y].perlinize(seed * 132467885l, 18, new Texture(TexturePath.GRASS2));
                map[x][y].reversePerlinize(seed * 4564646l, 10, new Texture(TexturePath.WATER2));
            }
        }
    }
    
    public Chunk getChunkAtPos(int x, int y) {
        return map[x][y];
    }

    public Chunk getCurrentlyLoadedChunk() {
        return map[curChunkX][curChunkY];
    }

    public double map(double x, double input_min, double input_max, double output_min, double output_max) {
        return (x - input_min)*(output_max-output_min)/(input_max-input_min)+output_min;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void addPlayerAtPos(APersonnage mob, int squarePosX, int squarePosY) {
        addPlayerAtPos(mob, 0, 0, squarePosX, squarePosY);
    }

    public void addPlayerAtPos(APersonnage mob, int chunkPosX, int chunkPosY, int squarePosX, int squarePosY) {
        mob.chunkPosX = chunkPosX;
        mob.chunkPosY = chunkPosY;
        mob.squarePosX = squarePosX;
        mob.squarePosY = squarePosY;
        map[chunkPosX][chunkPosY].addPlayerAtPos(mob, squarePosX, squarePosY);
    }
}