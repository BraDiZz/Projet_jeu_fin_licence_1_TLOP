package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 * Enumeration de tous les objets qui peuvent etre consommes
 * {@link #SUPERPOTION}
 * {@link #POTION}
 * {@link #POULET}
 * {@link #POMME}
 * {@link #PAIN}
 * {@link #JUS}
 * {@link #BUCHE}
 * {@link #ARMURE1}
 * {@link #ARMURE2}
 * {@link #ARMURE3}
 * {@link #EPEE1}
 * {@link #EPEE2}
 * {@link #EPEE3}
 */
public enum ObjetType {
    /**
     * Type de l'Objet est une superpotion 
     */
    SUPERPOTION("/assets/SuperPotion.png", true),
    /**
     * Type de l'Objet est une potion
     */
    POTION("/assets/Potion.png", true),
    /**
     * Type de l'Objet est du poulet
     */
    POULET("/assets/Poulet.png", true),
    /**
     * Type de l'Objet est une pomme
     */
    POMME("/assets/Pomme.png", true),
    /**
     * Type de l'Objet est du pain
     */
    PAIN("/assets/Pain.png", true),
    /**
     * Type de l'Objet est du jus
     */
    JUS("/assets/NoixCoco.png", true),
    /**
     * Type de l'Objet est du bois
     */
    BUCHE("/assets/Buche.png", false),
    /**
     * Type de l'Objet est une armure de niveau 1
     */
    ARMURE1("/assets/Armure1.png", true),
    /**
     * Type de l'Objet est une armure de niveau 2
     */
    ARMURE2("/assets/Armure2.png", true),
    /**
     * Type de l'Objet est une armure de niveau 3
     */
    ARMURE3("/assets/Armure3.png", true),
    /**
     * Type de l'Objet est une epee de niveau 1
     */
    EPEE1("/assets/Epee1.png", true),
    /**
     * Type de l'Objet est une epee de niveau 2
     */
    EPEE2("/assets/Epee2.png", true),
    /**
     * Type de l'Objet est une epee de niveau 3
     */
    EPEE3("/assets/Epee3.png", true);
    /**
     * Un String pour le chemin de l'image de l'objet
     */
    public String path;
    public boolean usable;
    /**
     * Constructeur par initialisation
     * @param path String
     */
    private ObjetType(String path, boolean usable) {
        this.path = path;
        this.usable = usable;
    }
}