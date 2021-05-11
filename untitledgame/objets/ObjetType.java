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
 */
public enum ObjetType {
    SUPERPOTION("assets/textures/objet_logo/SuperPotion.png"),
    POTION("assets/textures/objet_logo/Potion.png"),
    POULET("assets/textures/objet_logo/Poulet.png"),
    POMME("assets/textures/objet_logo/Pomme.png"),
    PAIN("assets/textures/objet_logo/Pain.png"),
    JUS("assets/textures/objet_logo/NoixCoco.png"),
    BOIS("assets/textures/objet_logo/Bois.png");
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