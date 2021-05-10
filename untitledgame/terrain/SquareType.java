package untitledgame.terrain;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 * Enumeration pour tous les types de Square qui existe
 * {@link #TREE}
 * {@link #BUSHES}
 * {@link #ROCK}
 * {@link #CHEST}
 * {@link #CHEST}
 * {@link #WATER1}
 * {@link #WATER2}
 * {@link #WATER3}
 * {@link #GRASS1}
 * {@link #GRASS2}
 * {@link #GRASS3}
 * {@link #BIG_ROCK}
 * {@link #SAND}
 */
public enum SquareType {
    TREE("assets/textures/terrain/Arbre.png", false),
    BUSHES("assets/textures/terrain/Buisson.png", false),
    ROCK("assets/textures/terrain/Caillou.png", true),
    CHEST("assets/textures/terrain/Coffre.png", false),
    WATER1("assets/textures/terrain/Eau1.png", true),
    WATER2("assets/textures/terrain/Eau2.png", true),
    WATER3("assets/textures/terrain/Eau3.png", true),
    GRASS1("assets/textures/terrain/Herbe1.png", false),
    GRASS2("assets/textures/terrain/Herbe2.png", false),
    GRASS3("assets/textures/terrain/Herbe3.png", false),
    BIG_ROCK("assets/textures/terrain/Rocher.png", true),
    SAND("assets/textures/terrain/Sable.png", false),
    /**
     * Un String pour le chemin de la texture
     */
    public final String path;
    /**
     * Un boolean pour savoir si un Square peut etre traverser par un personnage ou non
     */
    public final boolean hasBoundingBox;
    /**
     * Constructeur par initialisation
     * @param path String
     * @param hasBoundingBox boolean
     */
    private SquareType(String path, boolean hasBoundingBox) {
        this.path = path;
        this.hasBoundingBox = hasBoundingBox;
    }
}