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
    SUPERPOTION("assets/textures/objet_logo/SuperPotion.png"),
    /**
     * Type de l'Objet est une potion
     */
    POTION("assets/textures/objet_logo/Potion.png"),
    /**
     * Type de l'Objet est du poulet
     */
    POULET("assets/textures/objet_logo/Poulet.png"),
    /**
     * Type de l'Objet est une pomme
     */
    POMME("assets/textures/objet_logo/Pomme.png"),
    /**
     * Type de l'Objet est du pain
     */
    PAIN("assets/textures/objet_logo/Pain.png"),
    /**
     * Type de l'Objet est du jus
     */
    JUS("assets/textures/objet_logo/NoixCoco.png"),
    /**
     * Type de l'Objet est du bois
     */
    BUCHE("assets/textures/objet_logo/Buche.png"),
    /**
     * Type de l'Objet est une armure de niveau 1
     */
    ARMURE1("assets/textures/objet_logo/Armure1.png"),
    /**
     * Type de l'Objet est une armure de niveau 2
     */
    ARMURE2("assets/textures/objet_logo/Armure2.png"),
    /**
     * Type de l'Objet est une armure de niveau 3
     */
    ARMURE3("assets/textures/objet_logo/Armure3.png"),
    /**
     * Type de l'Objet est une epee de niveau 1
     */
    EPEE1("assets/textures/objet_logo/Epee1.png"),
    /**
     * Type de l'Objet est une epee de niveau 2
     */
    EPEE2("assets/textures/objet_logo/Epee2.png"),
    /**
     * Type de l'Objet est une epee de niveau 3
     */
    EPEE3("assets/textures/objet_logo/Epee3.png");
    /**
     * Un String pour le chemin de l'image de l'objet
     */
    public String path;
    /**
     * Constructeur par initialisation
     * @param path Stirng
     */
    private ObjetType(String path) {
        this.path = path;
    }
}