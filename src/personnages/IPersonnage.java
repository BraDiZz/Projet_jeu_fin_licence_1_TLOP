package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public interface IPersonnage {
    /**
     * Getter pour le nom du personnage
     * @return String
     */
    public String getNom();
    /**
     * Getter pour le nombre de points de vie du personnage
     * @return int
     */
	public int getPointsDeVie();
    /**
     * Getter pour le nombre de points de vie maximum du personnage
     * @return int
     */
    public int getPointsDeVieMax();
    /**
     * Getter pour l'armure du personnage
     * @return int
     */
	public int getArmure();
    /**
     * Getter pour l'armure maximum du personnage
     * @return int
     */
    public int getArmureMax();
    /**
     * Getter pour les points de degats du personnage
     * @return int
     */
	public int getPointsDAttaque();
    /**
     * Getter pour le niveau du personnage
     * @return
     */
    public int getNiveau();
    /**
     * Gette pour le type du personnage
     * @return MobType
     */
    public MobType getMobType();
    /**
     * Setter pour le nom du personnage
     * @param nom String
     */
    public void setNom(String nom);
    /**
     * Setter pour les points de vie a rajouter du personnage
     * @param pvARajouter int
     */
    public void setPointsDeVie(int pvARajouter);
    /**
     * Setter pour les points de vie max a rajouter du personnage
     * @param pvARajouter int
     */
    public void setPointsDeVieMax(int pvARajouter);
    /**
     * Setter pour le niveau du personnage
     * @param niveau int
     */
    public void setNiveau(int niveau);
    /**
     * Setter pour l'armure a rajouter du personnage
     * @param armureARajouter int
     */
    public void setArmure(int armureARajouter);
    /**
     * Setter pour l'armure max a rajouter du personnage
     * @param armureARajouter int
     */
    public void setArmureMax(int armureARajouter);
    /**
     * Setter pour les points d'attaque a rajouter du personnage
     * @param pointsAttaqueARajouter int
     */
    public void setPointsDAttaque(int pointsAttaqueARajouter);
    /**
     * Methode qui fait subir une attaque sur le personnage
     * @param degats int
     * @return boolean
     */
	public boolean subirAttaque(int degats);
    /**
     * Methode pour attaquer un personnage
     * @param p IPersonnage
     * @return boolean
     */
    public boolean attaquer(IPersonnage p);
    /**
     * Methode pour savoir si le personnage a encore des points de vie ou non
     * @return boolean
     */
    public boolean estEnVie();
    /**
     * Methode qui permet d'afficher toutes les statistiques du personnage
     * @return string
     */
    public String toString();
    /**
    * Methode qui permet de changer les statistiques du personnage en fonction du niveau
    */
    public void changeStats();
}