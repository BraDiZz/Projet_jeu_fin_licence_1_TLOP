package personnages;

public abstract class AVilain extends APersonnage {
	public AVilain(int niveau, int squarePosX, int squarePosY, MobType mobType) {
        super(niveau, squarePosX, squarePosY, mobType);
        initStats();
	}
	public void initStats() {
		if (getMobType() == MobType.WOLF) {
		  pointsDeVie = (int)50+(21*niveau);
	      pointsDeVieMax = (int) 50+(21*niveau);
	      pointsDAttaque = (int)50+(10*niveau);
	      armure = 0;
		}
	    else if(getMobType() == MobType.SKELETON) {
	    	pointsDeVie = (int) 100+(28*niveau);
	    	pointsDeVieMax = (int) 100+(28*niveau);
	    	pointsDAttaque = (int) 30 +(9*niveau);
	    	armure = 2*niveau;
	    }
	    else if(getMobType() == MobType.ORC) {
	    	pointsDeVie = (int) 200+(43*niveau);
	    	pointsDeVieMax = (int) 200+(43*niveau);
	    	pointsDAttaque = (int) 15+(5*niveau);
	    	armure = 5*niveau;
	    }
	    else if(getMobType() == MobType.BOSS) {
	    	pointsDeVie = 500;
	    	pointsDeVieMax = 500;
	    	pointsDAttaque = 120;
	    	armure = 50;
	    }
	}
    public boolean heroVaincu(AHero hero) {
        boolean heroVaincu = false;

        if (attaquer(hero)) {
            heroVaincu = true;
        }
        return heroVaincu;
    }
}