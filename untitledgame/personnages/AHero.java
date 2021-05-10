package untitledgame.personnages;

import untitledgame.objets.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public abstract class AHero extends APersonnage {
    /**
    * Un int pour la quantite d'experience que le personnage a
    */
	private int xp;
	/**
	* Un int pour la quantite d'experience que le personnage doit avoir avant de monter de niveau
	*/
	private int xpAAtteindre;
    /**
     * Un Inverntaire pour le contenu de tous les objets qu'il possede
     */
	private Inventaire inventaire;
    /**
     * Un int pour le nombre d'objets qu'il possede dans son inventaire
     */
    private int nombreItems;
    /**
     * Constructeur par initialisation
     * @param nom String
     * @param pointsDeVie int
     * @param pointsDeVieMax int
     * @param pointsDAttaque int
     * @param armure int
     * @param niveau int
     * @param squarePosX int
     * @param squarePosY int
     * @param mobType MobType
     */
	public AHero(String nom, int pointsDeVie, int pointsDeVieMax, int pointsDAttaque, int armure, int niveau, int squarePosX, int squarePosY, MobType mobType) {
        super(nom, pointsDeVie, pointsDeVieMax, pointsDAttaque, armure, niveau, squarePosX, squarePosY, mobType);
        xp = 0;
        xpAAtteindre = 200;
        inventaire = new Inventaire();
        nombreItems = inventaire.getTaille();
	}
    /**
     * Getter pour l'inventaire
     * @return Inventaire
     */
    public Inventaire getInventaire() {
        return inventaire;
    }
    /**
    * Getter pour l'experience 
    * @return int
    */
	public int getXp() {
		return xp;
	}
    /**
    * Getter pour l'experience a atteindre pour monter de niveau
    * @return int
    */
	public int getXpAAtteindre() {
		return xpAAtteindre;
	}
    /**
    * Methode pour augmenter le niveau du personnage si l'experience est suffisante
    * @param xpGagne int
    */
    //!! On appellera TOUJOURS cette fonction lorsque le joueur gagnera de l'xp
	public void gainXP(int xpGagne) {
        xp += xpGagne;
        if (xp >= xpAAtteindre) {
            addNiveau(1);
            xp = 0;
        }
	}
    /** 
    * Methode pour consommer un objet
    * @param nourriture AObjet
    */ 
    public void consommerObjet(AObjet objet) {
        addPointsDeVie(objet.getPvRendus());
        gainXP(objet.getXpDonne());
    }
    /**
	* Setter pour les PV
	* @param pvARajouter int
	*/
	public void addPointsDeVie(int pvARajouter) {
		pointsDeVie = (pointsDeVie + pvARajouter) > pointsDeVieMax ? pointsDeVieMax : (pointsDeVie + pvARajouter);
	}
    /**
    * Methode pour donner de l'experience au personnage si l'ennemi est vaincu
    * @param vilain AVilain
    * @return boolean
    */
    public boolean monstreVaincu(AVilain vilain) {
        boolean monstreVaincu = false;

        if (attaquer(vilain)) {
            // Si le joueur tue un monstre, il gagne 10 d'xp fois le niveau du monstre ( exemple je bas un monstre niveau 3 je gagne 30 xp)
       	    gainXP(vilain.niveau*10);
            vilain = null;
            monstreVaincu = true;
        }
        return monstreVaincu;
    }
    /**
     * Methode pour mettre a jour les statistiques du personnage si il monte de niveau
     */
    public void actualiserStats() {
        int ratio = 15;
        pointsDeVie = (int)(pointsDeVie*ratio/100);
        pointsDeVieMax = (int)(pointsDeVieMax*ratio/100);
        armure = (int)(armure*ratio/100);
        pointsDAttaque = (int)(pointsDAttaque*ratio/100);
    }
}