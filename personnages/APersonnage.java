package personnages;

/**
*  Classe abstraite Personnage 
*/

public abstract class APersonnage implements IPersonnage{
	private String nom;
	private int pointsDeVie;
	private int pointsDAttaque;
	private int armure;
    private int pointsDeVieMax;
	private int armureMax;
	private int niveau;

    /**
    *   Constructeur par défaut
    */
	public APersonnage(){
		nom = "hero";
		pointsDeVie = 100;
		pointsDeVieMax = 100;
		pointsDAttaque = 20;
		armure = 10;
		armureMax = 50;
		niveau = 1;
	}
	/**
	*   Constructeur par initialisation
	* @param nom
	* @param pointsDeVie
	* @param pointsDAttaque
	* @param armure
	*/
	public APersonnage(String nom, int pointsDeVie, int pointsDAttaque, int armure) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
		this.pointsDAttaque = pointsDAttaque;
		this.armure = armure;
	}
	/**
	* methode get de la variable nom
	* @return le nom
	*/
	public String getNom() {
		return nom;
	}
	/**
	* methode get de la variable pointsDeVie
	* @return les points de vie
	*/
	public int getPointsDeVie() {
		return pointsDeVie;
	}
    
    /**
    * methode get de la variable pointsDeVieMax
    * @return les points de vie max
    */
	public int getPointsDevieMax() {
		return pointsDeVieMax;
	} 
	/**
	* methode get de la variable pointsDAttaque
	* @return les points d'attaque
	*/
	public int getPointsDAttaque() {
		return pointsDAttaque;
	}
	/**
	* methode get de la variable armure 
	* @return l'armure
	*/
	public int getArmure(){
		return armure;
	}
    
    /**
    * methode get de armureMax
    * @return l'armure max
    */
	public int getArmureMax() {
		return armureMax;
	}

	/**
	*	
	*/

	/**
	* methode attaque qui permet au personnage de lancer une attaque
	* @param nomDuPerso personnage a attaquer
	* @return les degats infligés. 
	*/
	public boolean attaquer(IPersonnage nomDuPerso) {

           boolean uniteTuee = false;
	       if (nomDuPerso.subirAttaque(pointsDAttaque))
	       	{
	       		uniteTuee = true;
	       	}
           return uniteTuee;

	}
	/**
	* Methode subirAttaque qui retire des pv en fonction des degats recus 
	* @param degats seront les degats a infliger ( sans prendre l'armure en compte )
	* @return true si l'unité n'a plus de vie
	*/
    public boolean subirAttaque(int degats) {

        boolean plusDeVie = false;
        if ( degats < armure ) {
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
    * methode manger qui permet de recuperer des pv 
    */
    public void manger(int pointsDeVieARajouter) {

    	pointsDeVie += pointsDeVieARajouter;
    	if ( pointsDeVie > pointsDeVieMax) {
    		pointsDeVie = pointsDeVieMax;
    	}
    }
    /*public abstract gainDeNiveau(int xp)*/
}