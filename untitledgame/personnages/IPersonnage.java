package untitledgame.personnages;

import untitledgame.texture.Texture;

/** 
* Interface IPersonnage qui indique les actions de tous les persos
* @version 19/04/2021
* @author Kouadjo
*/
public interface IPersonnage {

    /**
    * @return le nom du personnage
    */
    public String getNom();

    /**
    * @return le nombre de points de vie
    */
	public int getPointsDeVie();
    
    /**
    * @return les points de vie max 
    */
    public int getPointsDeVieMax();

	/** 
	* @return les points d'armure
	*/
	public int getArmure();
    
    /**
    * @return l'armure max 
    */
    public int getArmureMax();

    /**
    * @return les points d'attaque
    */
	public int getPointsDAttaque();
    
    /**
    * @return le niveau du personnage
    */
    public int getNiveau();

    /**
    * @return l'attribut texture du personnage
    */
    public Texture getTexture();

    /**
    * @param nom nouveau nom
    */
    public void setNom(String nom);
    
    /**
    * @param pvARajouter qui seront les pv a rajouter
    */
    public void setPointsDeVie(int pvARajouter);

    /**
    * @param pvARajouter qui seront les pv max a rajouter
    */
    public void setPointsDeVieMax(int pvARajouter);

    /**
    * setter de niveau 
    * @param niveau que  l'on rajoute (généralement 1)
    */
    public void setNiveau(int niveau);

    /**
    * @param armureARajouter qui sera l'armure a rajouter
    */
    public void setArmure(int armureARajouter);

    /**
    * @param armureARajouter qui sera l'armure max a rajouter
    */
    public void setArmureMax(int armureARajouter);

    /**
    * @param pointsAttaqueARajouter qui seront les points d'attaque a rajouter
    */
    public void setPointsDAttaque(int pointsAttaqueARajouter);


	/**
	* @param degats les degats infligés
	* @return vrai si l'unité est tuée, faux sinon
	*/
	public boolean subirAttaque(int degats);

	/**
	* @param p personnage a attaquer
	* @return true si l'unité est tuée, faux sinon.
	*/
    public boolean attaquer(IPersonnage p);

    /**
    * @return true si je personnage est en vie, faux sinon.
    */
    public boolean estEnVie();

    /**
    * @return les stats du personnage sous forme de String
    */
    public String toString();

    /**
    * Permet de changer les stats du personnage en fonction du niveau
    */
    public void changeStats();

}