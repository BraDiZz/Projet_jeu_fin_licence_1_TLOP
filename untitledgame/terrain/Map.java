package untitledgame.terrain;

import untitledgame.terrain.Chunk;

public class Map {
    private Chunk[][] map;
    private int sizeX;
    private int sizeY;

    public Map(int sizeX, int sizeY) {
        map = new Chunk[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        populateMap();
    }

    public Map() {
        map = new Chunk[4][4];
        populateMap();
    }

    private void populateMap() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = new Chunk(x, y);
            }
        }
    }
    
    public Chunk getChunkAtPos(int x, int y) {
        return map[x][y];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
}