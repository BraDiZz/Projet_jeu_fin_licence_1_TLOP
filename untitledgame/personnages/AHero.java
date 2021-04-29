package personnages;
import objets.*;
import java.util.Vector;
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
	private Vector<Nourriture> sacDeNourriture;
	private Vector<Boisson> sacDeBoissons;
    private int nombreItems;
    private final int nombreItemsMax = 10;

	public AHero() {
		super();
		xp = 0;
		xpAAtteindre = 200;
		sacDeBoissons = new Vector<Boisson>();
		sacDeBoissons.add(Boisson.JUS);
		sacDeNourriture = new Vector<Nourriture>();
		sacDeNourriture.add(Nourriture.POMME);
        nombreItems = sacDeBoissons.size() + sacDeNourriture.size();

	}
	public AHero(int pointsDeVie, int pointsDeVieMax, int pointsDAttaque, int armure, int armureMax, int niveau){
        super(pointsDeVie,pointsDeVieMax,pointsDAttaque,armure,armureMax,niveau);
        xp = 0;
        xpAAtteindre = 200;
	}

	/**
	* methode gainXP qui permet de rajouter de l'xp au hero
	* @param xpGagne represente l'xp a rajouter
	* @return vrai si le joueur gagne un niveau
	*/
	public boolean gainXP(int xpGagne) {

		boolean gainNiveau = false;

		xp += xpGagne;
		if (xp >= xpAAtteindre) {
			gainNiveau = true;
		}
		return gainNiveau;
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
    * methode joueurMonteNiveau qui permet de modifier le niveau et l'xp du joueur lorsqu'il atteint son xp maximal
    * !! On appellera TOUJOURS cette fonction lorsque le joueur gagnera de l'xp
    * @param xpGagne qui sera l'xp a rajouter
    */
	public  void joueurMonteNiveau(int xpGagne) {
        if (gainXP(xpGagne)) {
           changeStats();
        }
	}

    /** 
    * methode manger qui permet de recuperer des pv
    * @param nourriture qui sera l'objet consommé  
    */ 
    public void manger(Nourriture nourriture) { 
 
    	if (nourriture == Nourriture.POMME ) {
    		setPointsDeVie(10);
    	}
    	if (nourriture == Nourriture.PAIN) {
    		setPointsDeVie(20);
    	}
    	if (nourriture == Nourriture.POULET) {
    		setPointsDeVie(30);
    	}
    }
    /**
    * methode boire qui permet de gagner de l'xp
    * @param boisson qui sera l'objet consommé
    */ 
    public void boire(Boisson boisson) {
       
        if (boisson == Boisson.JUS)  {
        	joueurMonteNiveau(20);
        }
        if (boisson == Boisson.POTION) {
        	joueurMonteNiveau(35);
        }
        if (boisson == Boisson.SUPERPOTION) {
        	joueurMonteNiveau(60);
        }
    }
    /**
    * methode monstreVaincu qui donne de l'xp au joueur si il bat un monstre
    * @param vilain qui sera le monstre a battre
    */
    public boolean monstreVaincu(AVilain vilain) {

        boolean monstreVaincu = false;

       int xpRecompense = 0;

       if (attaquer(vilain)) {
       	 // Si le joueur tue un monstre, il gagne 10 d'xp fois le niveau du monstre ( exemple je bas un monstre niveau 3 je gagne 30 xp)
       	 xpRecompense += vilain.getNiveau()*10;
       	 joueurMonteNiveau(xpRecompense);
         monstreVaincu = true;
       }
       return monstreVaincu;
    }

    public void changeStats() {

        int niveau = getNiveau();
        // le ratio represente l'amelioration a apporter en pourcentage
        int ratio = 15;
        int pvARajouter = (int) getPointsDeVie()*ratio/100;
        int pvMaxARajouter = (int) getPointsDeVieMax()*ratio/100;
        int armureARajouter = (int) getArmure()*ratio/100;
        int armureMaxARajouter = (int) getArmureMax()*ratio/100;
        int degatsARajouter = (int) getPointsDAtttaque()*ratio/100;

        setPointsDeVie(pvARajouter);
        setPointsDeVieMax(pvMaxARajouter);
        setArmure(armureARajouter);
        setArmureMax(armureMaxARajouter);
        setPointsAttaque(degatsARajouter);
    
    }
}