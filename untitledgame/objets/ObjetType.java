package untitledgame.objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 * Enumeration de tous les objets qui peuvent etre consommes
 * {@link #SUPERPOTION}
 * {@link #POTION}
 * {@link #POULET}
 * {@link #POMME}
 * {@link #PAIN}
 * {@link #JUS}
 * {@link #BUCHE}
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
    BUCHE("assets/textures/objet_logo/Buche.png");
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