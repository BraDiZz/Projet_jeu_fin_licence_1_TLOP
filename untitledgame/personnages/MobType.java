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
    /**
     * Type du Mob est un Archer
     */
    ARCHER("assets/textures/personnage/Archer.png"),
    /**
     * Type du Mob est un Assassin
     */
    MURDERER("assets/textures/personnage/Assassin.png"),
    /**
     * Type du Mob est un Boss
     */
    BOSS("assets/textures/personnage/Boss.png"),
    /**
     * Type du Mob est un Chevalier
     */
    KNIGHT("assets/textures/personnage/Chevalier.png"),
    /**
     * Type du Mob est un Loup
     */
    WOLF("assets/textures/personnage/Loup.png"),
    /**
     * Type du Mob est un Orc
     */
    ORC("assets/textures/personnage/Orc.png"),
    /**
     * Type du Mob est un Squelette
     */
    SKELETON("assets/textures/personnage/Squelette.png"),
    /**
     * Type du Mob est Inconnu
     */
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