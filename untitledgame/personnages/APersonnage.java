package untitledgame.personnages;
/** 
*  Classe abstraite Personnage  
*/ 
 
public abstract class APersonnage {
	private String nom;
	protected int pointsDeVie;
	protected int pointsDAttaque;
	protected int armure;
    protected int pointsDeVieMax;
	protected int niveau;
	public int squarePosX;
	public int squarePosY;
	private MobType mobType;

	/** 
	*   Constructeur par initialisation 
	* @param pointsDeVie
	* @param pointsDAttaque
	* @param armure
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

	public APersonnage(int niveau, int squarePosX, int squarePosY, MobType mobType) {
		this.niveau = niveau;
		this.squarePosX = 0;
		this.squarePosY = 0;
		this.mobType = mobType;
	}
	/** 
	* getter de la variable nom 
	* @return le nom 
	*/ 
	public String getNom() { 
		return nom; 
	}

	/** 
	* getter du mobType
	* @return un MobType
	*/ 
	public MobType getMobType() {
		return mobType;
	}

    /**
    * setter de niveau
    * @param niveau qui sera le niveau a rajouter ( généralement 1 )
    */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

	public void addNiveau(int niveau) {
		setNiveau(niveau+1);
	}

	/** 
	* Methode subirAttaque qui retire des pv en fonction des degats recus  
	* @param degats seront les degats a infliger ( sans prendre l'armure en compte ) 
	* @return true si l'unité n'a plus de vie 
	*/ 
    public boolean subirAttaque(int degats) { 
        boolean plusDeVie = false; 
        if ( degats <= armure ) { 
        	pointsDeVie -= 1; 
        } 
        pointsDeVie -= (degats - armure); 
 
        if ( pointsDeVie <= 0 ) 
        { 
        	plusDeVie = true; 
        } 
        return plusDeVie; 
    } 
 
	/** 
	* methode attaque qui permet au personnage de lancer une attaque a l'aide de la methode subirAttaque
	* @param nomDuPerso personnage a attaquer 
	* @return vrai si l'unitée est tuée faux sinon.
	*/ 
	public boolean attaquer(APersonnage nomDuPerso) {
        return nomDuPerso.subirAttaque(pointsDAttaque);  
	}
}