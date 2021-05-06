package untitledgame.personnages;

public enum MobType {
    ARCHER("assets/textures/personnage/Archer.png"),
    MURDERER("assets/textures/personnage/Assassin.png"),
    BOSS("assets/textures/personnage/Boss.png"),
    KNIGHT("assets/textures/personnage/Chevalier.png"),
    WOLF("assets/textures/personnage/Loup.png"),
    UNKNOWN("assets/textures/personnage/Inconnu.png");

    public final String path;

    private MobType(String path) {
        this.path = path;
    }
}