package untitledgame.terrain;

import untitledgame.terrain.Chunk;

public class Map {
    private Chunk[][] map;

    public Map(int sizeX, int sizeY) {
        map = new Chunk[sizeX][sizeY];
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
}