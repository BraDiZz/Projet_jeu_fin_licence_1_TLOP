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
    ARCHER("/assets/Archer.png", "Archer"),
    /**
     * Type du Mob est un Assassin
     */
    MURDERER("/assets/Assassin.png", "Assassin"),
    /**
     * Type du Mob est un Chevalier
     */
    KNIGHT("/assets/Chevalier.png", "Chevalier"),
    /**
     * Type du Mob est un Boss
     */
    BOSS("/assets/Boss.png", "Boss"),
    /**
     * Type du Mob est un Loup
     */
    WOLF("/assets/Loup.png", "Loup"),
    /**
     * Type du Mob est un Orc
     */
    ORC("/assets/Orc.png", "Orc"),
    /**
     * Type du Mob est un Squelette
     */
    SKELETON("/assets/Squelette.png", "Squelette");
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