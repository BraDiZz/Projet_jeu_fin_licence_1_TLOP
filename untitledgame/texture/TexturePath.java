package untitledgame.texture;

public enum TexturePath {
    TREE("assets/textures/terrain/Arbre.png"),
    BUSHES("assets/textures/terrain/Buisson.png"),
    ROCK("assets/textures/terrain/Caillou.png"),
    CHEST("assets/textures/terrain/Coffre.png"),
    WATER1("assets/textures/terrain/Eau1.png"),
    WATER2("assets/textures/terrain/Eau2.png"),
    WATER3("assets/textures/terrain/Eau3.png"),
    GRASS1("assets/textures/terrain/Herbe1.png"),
    GRASS2("assets/textures/terrain/Herbe2.png"),
    GRASS3("assets/textures/terrain/Herbe3.png"),
    BIG_ROCK("assets/textures/terrain/Rocher.png"),
    SAND("assets/textures/terrain/Sable.png"),

    ARCHER("assets/textures/personnage/Archer.png"),
    MURDERER("assets/textures/personnage/Assassin.png"),
    BOSS("assets/textures/personnage/Boss.png"),
    KNIGHT("assets/textures/personnage/Chevalier.png"),
    WOLF("assets/textures/personnage/Loup.png");

    public final String path;

    private TexturePath(String path) {
        this.path = path;
    }
}