package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public abstract class APersonnage implements java.io.Serializable {
	/**
	 * Un String pour le nom du personnage
	 */
	private String nom;
	/**
	 * Un int pour les points de vie du personnage
	 */
	protected int pointsDeVie;
	/**
	 * Un int pour les points de degats du personnage
	 */
	protected int pointsDAttaque;
	/**
	 * Un int pour l'armure du personnage
	 */
	protected int armure;
	/**
	 * Un int pour les points de vie maximum du personnage
	 */
    protected int pointsDeVieMax;
	/**
	 * Un int pour le niveau du personnage
	 */
	protected int niveau;
	/**
	 * Un int pour la position sur l'axe X du personnage
	 */
	public int squarePosX;
	/**
	 * Un int pour la position sur l'axe Y du personnage
	 */
	public int squarePosY;
	/**
	 * Un MobType pour le type du personnage
	 */
	private MobType mobType;
	/** 
	* Constructeur par initialisation pour le joueur
	* @param pointsDeVie int
	* @param pointsDeVieMax int
	* @param pointsDAttaque int
	* @param armure int
	* @param niveau int
	* @param squarePosX int
	* @param squarePosY int
	* @param mobType MobType
	*/
	public APersonnage(String nom, int pointsDeVie, int pointsDeVieMax, int pointsDAttaque, int armure, int niveau, int squarePosX, int squarePosY, MobType mobType) { 
		this.nom = nom;
		this.pointsDeVie = pointsDeVie; 
		this.pointsDeVieMax = pointsDeVieMax;
		this.pointsDAttaque = pointsDAttaque; 
		this.armure = armure;
		this.niveau = niveau;
		this.squarePosX = squarePosX;
		this.squarePosY = squarePosY;
		this.mobType = mobType;
	}
	/**
	 * Constructeur par initialisation pour les ennemis
	 * @param niveau int
	 * @param squarePosX int
	 * @param squarePosY int
	 * @param mobType Mobtype
	 */
	public APersonnage(int niveau, int squarePosX, int squarePosY, MobType mobType) {
		this.niveau = niveau;
		this.squarePosX = squarePosX;
		this.squarePosY = squarePosY;
		this.mobType = mobType;
	}
	/** 
	* Getter pour le nom du personnage
	* @return String
	*/ 
	public String getNom() { 
		return nom; 
	}
	/**
	* Getter pour les points de vie du personnage
	* @return int
	*/
	public int getPointDeVie(){
		return pointsDeVie;
	}
	/**
	* Getter pour les points de vie max du hero
	* @return int
	*/
	public int getPointDeVieMax() {
		return pointsDeVieMax;
	}
	/**
	* Getter pour l'attaque du hero
	* @return int
	*/
	public int getAttaque() {
		return pointsDAttaque;
	}
	/**
	* Getter pour l'armure du hero
	* @return int
	*/
	public int getArmure() {
		return armure;
	}
	/**
	* Getter pour le niveau du hero
	* @return int
	*/
	public int getNiveau() {
		return niveau;
	}
	/** 
	* Getter pour le type du personnage
	* @return MobType
	*/ 
	public MobType getMobType() {
		return mobType;
	}
    /**
    * Setter pour le niveau du personnage
    * @param niveau int
    */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
	/**
	 * Methode pour augmenter le niveau du personnage de 1
	 * @param niveau int
	 */
	public void addNiveau(int niveau) {
		setNiveau(niveau+1);
	}
	/** 
	* Methode qui modifie les points de vie du personnage en fonction des degats qu'il prend
	* @param degats int
	* @return boolean
	*/ 
    public boolean subirAttaque(int degats) { 
        boolean plusDeVie = false; 
        if ( degats <= armure ) { 
        	pointsDeVie -= 1; 
        } 
        pointsDeVie -= (degats - armure); 
 
        if ( pointsDeVie <= 0 ) { 
        	plusDeVie = true; 
        } 
        return plusDeVie; 
    } 
	/** 
	* Methode pour attaquer un personnage 
	* @param nomDuPerso APersonnage 
	* @return boolean
	*/ 
	public boolean attaquer(APersonnage nomDuPerso) {
        return nomDuPerso.subirAttaque(pointsDAttaque);  
	}
}