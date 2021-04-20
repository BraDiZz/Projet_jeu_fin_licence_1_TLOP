package personnages;

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
    * @param pointsDeVieAAjouter qui seront les pv a rajouter
    */
    public void manger(int pointsDeVieAAjouter);

	/** 
	* @return les points d'armure
	*/
	public int getArmure();
 

    /**
    * @return les points d'attaque
    */
	public int getPointsDAttaque();

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

}