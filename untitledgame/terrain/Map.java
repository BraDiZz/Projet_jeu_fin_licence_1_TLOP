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
        this(4, 4);
        populateMap();
    }

    private void populateMap() {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                map[x][y] = new Chunk(x, y);
                map[x][y].perlinize(132467885l);
                map[x][y].addFeatures("assets/textures/terrain/Arbre.png", 8);
                map[x][y].addFeatures("assets/textures/terrain/Caillou.png", 6);
                map[x][y].addFeatures("assets/textures/terrain/Buisson.png", 4);
            }
        }
    }
    
    public Chunk getChunkAtPos(int x, int y) {
        return map[x][y];
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
}