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
                Chunk chunk = new Chunk(x, y);
                chunk.addFeatures(new Texture(TexturePath.TREE), 6);
                chunk.addFeatures(new Texture(TexturePath.ROCK), 2);
                chunk.addFeatures(new Texture(TexturePath.BUSHES), 3);
                chunk.perlinize(seed * 14894465l, 18, new Texture(TexturePath.GRASS1));
                chunk.perlinize(seed * 132467885l, 18, new Texture(TexturePath.GRASS2));
                chunk.reversePerlinize(seed * 4564646l, 10, new Texture(TexturePath.WATER2));
                map[x][y] = chunk;
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

    public void addMobAtPos(APersonnage mob, Chunk chunk, int xSquare, int ySquare) {
        try {
            if (chunk == null ^ xSquare < 0 ^ySquare < 0 ^ xSquare > 14 ^ ySquare > 14) {
                throw new IllegalArgumentException("Chunk is null, or square position is invalid. (must be [0;14]");
            }
            mob.squarePosX = chunk.getChunkPosX()*15+xSquare;
            mob.squarePosY = chunk.getChunkPosY()*15+ySquare;
            map[chunk.getChunkPosX()][chunk.getChunkPosY()].setMobAtPos(mob, xSquare%15, ySquare%15);
        } catch(IllegalArgumentException err) {
            err.printStackTrace();
        }
    }

    public void changeMobPos(APersonnage mob, Direction direction) {
        int xNextPosition = mob.squarePosX+direction.x;
        int yNextPosition = mob.squarePosY+direction.y;
        if (xNextPosition >= 0 && xNextPosition < sizeX*15 && yNextPosition >= 0 && yNextPosition < sizeY*15) {
            map[(int)(mob.squarePosX/15)][(int)(mob.squarePosY/15)].removeMobAtPos(mob.squarePosX%15, mob.squarePosY%15);
            if ((int)(xNextPosition/15) != (int)(mob.squarePosX/15) ^ (int)(yNextPosition/15) != (int)(mob.squarePosY/15)) {
                curChunkX += direction.x;
                curChunkY += direction.y;
            }
            mob.squarePosX = xNextPosition;
            mob.squarePosY = yNextPosition;
            System.out.println(getCurrentlyLoadedChunk().getChunkPosX() + " " + getCurrentlyLoadedChunk().getChunkPosY() + " " + curChunkX + " " + curChunkY);
            map[(int)(mob.squarePosX/15)][(int)(mob.squarePosY/15)].setMobAtPos(mob, mob.squarePosX%15, mob.squarePosY%15);
        }
    }
}