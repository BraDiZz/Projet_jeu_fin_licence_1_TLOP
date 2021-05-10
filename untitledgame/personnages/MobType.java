package untitledgame.personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 * Enumeration de tous les types de mob qu'il existe
 * {@link #ARCHER}
 * {@link #MURDERER}
 * {@link #BOSS}
 * {@link #KNIGHT}
 * {@link #WOLF}
 * {@link #UNKNOWN}
 */
public enum MobType {
    ARCHER("assets/textures/personnage/Archer.png"),
    MURDERER("assets/textures/personnage/Assassin.png"),
    BOSS("assets/textures/personnage/Boss.png"),
    KNIGHT("assets/textures/personnage/Chevalier.png"),
    WOLF("assets/textures/personnage/Loup.png"),
    UNKNOWN("assets/textures/personnage/Inconnu.png");
    /**
     * Un String pour le chemin de l'image du mob
     */
    public final String path;
    /**
     * Constructeur par initialisation
     * @param path String
     */
    private MobType(String path) {
        this.path = path;
    }
}