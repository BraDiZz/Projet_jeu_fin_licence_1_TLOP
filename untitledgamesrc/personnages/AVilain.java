package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public abstract class AVilain extends APersonnage {
	/**
	 * Constructeur par initialisation
	 * @param niveau int
	 * @param squarePosX int
	 * @param squarePosY int
	 * @param mobType MobType
	 */
	public AVilain(int niveau, int squarePosX, int squarePosY, MobType mobType) {
        super(niveau, squarePosX, squarePosY, mobType);
        initStats();
	}
	/**
	 * Methode pour initialiser les statistiques de l'ennemi en fonction du niveau du joueur
	 */
	public void initStats() {
		if (getMobType() == MobType.WOLF) {
		  pointsDeVie = (int)50+(12*niveau);
	      pointsDeVieMax = (int) 50+(12*niveau);
	      pointsDAttaque = (int)40+(10*niveau);
	      armure = 0;
		}
	    else if(getMobType() == MobType.SKELETON) {
	    	pointsDeVie = (int) 100+(17*niveau);
	    	pointsDeVieMax = (int) 100+(17*niveau);
	    	pointsDAttaque = (int) 27 +(8*niveau);
	    	armure = 2*niveau;
	    }
	    else if(getMobType() == MobType.ORC) {
	    	pointsDeVie = (int) 175+(25*niveau);
	    	pointsDeVieMax = (int) 175+(25*niveau);
	    	pointsDAttaque = (int) 20+(4*niveau);
	    	armure = 4*niveau;
	    }
	    else if(getMobType() == MobType.BOSS) {
	    	pointsDeVie = 800;
	    	pointsDeVieMax = 800;
	    	pointsDAttaque = 100;
	    	armure = 100;
	    }
	}
	/**
	 * Methode pour savoir si le personnage du joueur n'a plus de points de vie ou non
	 * @param hero AHero
	 * @return boolean
	 */
    public boolean heroVaincu(AHero hero) {
        boolean heroVaincu = false;

        if (attaquer(hero)) {
            heroVaincu = true;
        }
        return heroVaincu;
    }
}