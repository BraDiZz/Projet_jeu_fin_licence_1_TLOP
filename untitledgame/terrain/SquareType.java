package untitledgame.terrain;

public enum SquareType {
    TREE("assets/textures/terrain/Arbre.png", true),
    BUSHES("assets/textures/terrain/Buisson.png", true),
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

    ARCHER("assets/textures/personnage/Archer.png", true),
    MURDERER("assets/textures/personnage/Assassin.png", true),
    BOSS("assets/textures/personnage/Boss.png", true),
    KNIGHT("assets/textures/personnage/Chevalier.png", true),
    WOLF("assets/textures/personnage/Loup.png", true),
    UNKNOWN("assets/textures/personnage/Inconnu.png", true);

    public final String path;
    public final boolean hasBoundingBox;

    private SquareType(String path, boolean hasBoundingBox) {
        this.path = path;
        this.hasBoundingBox = hasBoundingBox;
    }
}