package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 * Enumeration de tous les types de mob qu'il existe
 * {@link #ARCHER}
 * {@link #MURDERER}
 * {@link #KNIGHT}
 * {@link #BOSS}
 * {@link #WOLF}
 * {@link #ORC}
 * {@link #SKELETON}
 */
public enum MobType {
    /**
     * Type du Mob est un Archer
     */
    ARCHER("assets/textures/personnage/Archer.png", "Archer"),
    /**
     * Type du Mob est un Assassin
     */
    MURDERER("assets/textures/personnage/Assassin.png", "Assassin"),
    /**
     * Type du Mob est un Chevalier
     */
    KNIGHT("assets/textures/personnage/Chevalier.png", "Chevalier"),
    /**
     * Type du Mob est un Boss
     */
    BOSS("assets/textures/personnage/Boss.png", "Boss"),
    /**
     * Type du Mob est un Loup
     */
    WOLF("assets/textures/personnage/Loup.png", "Loup"),
    /**
     * Type du Mob est un Orc
     */
    ORC("assets/textures/personnage/Orc.png", "Orc"),
    /**
     * Type du Mob est un Squelette
     */
    SKELETON("assets/textures/personnage/Squelette.png", "Squelette");
    /**
     * Un String pour le chemin de l'image du mob
     */
    public final String path;
    /**
     * Un String pour le nom par defaut de l'ennemi
     */
    public final String defaultName;
    /**
     * Constructeur par initialisation
     * @param path String
     */
    private MobType(String path, String defaultName) {
        this.path = path;
        this.defaultName = defaultName;
    }
}