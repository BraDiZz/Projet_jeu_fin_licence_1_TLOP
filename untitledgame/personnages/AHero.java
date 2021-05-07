package untitledgame.personnages;

import java.util.Vector;
import untitledgame.objets.*;
/**
*   Classe abstraite AHero
*/

public abstract class AHero extends APersonnage {

    /**
    * Attribut xp qui represente l'experience qu'accumule le hero
    */
	private int xp;
	/**
	* Represente l'xp a atteindre
	*/
	private int xpAAtteindre;
	private Inventaire inventaire;
    private int nombreItems;

	public AHero(String nom, int pointsDeVie, int pointsDeVieMax, int pointsDAttaque, int armure, int niveau, int squarePosX, int squarePosY, MobType mobType) {
        super(nom, pointsDeVie, pointsDeVieMax, pointsDAttaque, armure, niveau, squarePosX, squarePosY, mobType);
        xp = 0;
        xpAAtteindre = 200;
        inventaire = new Inventaire();
        nombreItems = inventaire.getTaille();
	}

    public Inventaire getInventaire() {
        return inventaire;
    }
    
    /**
    * getter de l'attribut xp 
    * @return xp
    */
	public int getXp() {
		return xp;
	}

    /**
    * getter de l'attribut xpAAtteindre
    * @return xpAAtteindre
    */
	public int getXpAAtteindre() {
		return xpAAtteindre;
	}
    
    /**
    * methode gainXP qui permet de modifier le niveau et l'xp du joueur lorsqu'il atteint son xp maximal
    * !! On appellera TOUJOURS cette fonction lorsque le joueur gagnera de l'xp
    * @param xpGagne qui sera l'xp a rajouter
    */
	public void gainXP(int xpGagne) {
        xp += xpGagne;
        if (xp >= xpAAtteindre) {
            addNiveau(1);
            xp = 0;
        }
	}

    /** 
    * methode manger qui permet de recuperer des pv
    * @param nourriture qui sera l'objet consommé  
    */ 
    public void consommerObjet(AObjet objet) {
        addPointsDeVie(objet.getPvRendus());
        gainXP(objet.getXpDonne());
    }

    /**
	* setter de pointsDeVie
	* @param pvARajouter qui seront les pv a rajouter
	*/
	public void addPointsDeVie(int pvARajouter) {
		pointsDeVie = (pointsDeVie + pvARajouter) > pointsDeVieMax ? pointsDeVieMax : (pointsDeVie + pvARajouter);
	}

    /**
    * methode monstreVaincu qui donne de l'xp au joueur si il bat un monstre
    * @param vilain qui sera le monstre a battre
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

    public void actualiserStats() {
        int ratio = 15;
        pointsDeVie = (int)(pointsDeVie*ratio/100);
        pointsDeVieMax = (int)(pointsDeVieMax*ratio/100);
        armure = (int)(armure*ratio/100);
        pointsDAttaque = (int)(pointsDAttaque*ratio/100);
    }
}