package untitledgame.terrain;

import untitledgame.terrain.Chunk;

public class Map {
    private Chunk[][] map;
    private int sizeX;
    private int sizeY;
    private long seed;

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
                map[x][y].addFeatures("assets/textures/terrain/Arbre.png", 6);
                map[x][y].addFeatures("assets/textures/terrain/Caillou.png", 2);
                map[x][y].addFeatures("assets/textures/terrain/Buisson.png", 3);
                map[x][y].perlinize(seed * 14894465l, 18, "assets/textures/terrain/Herbe1.png");
                map[x][y].perlinize(seed * 132467885l, 18, "assets/textures/terrain/Herbe2.png");
                map[x][y].reversePerlinize(seed * 4564646l, 10, "assets/textures/terrain/Eau2.png");
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