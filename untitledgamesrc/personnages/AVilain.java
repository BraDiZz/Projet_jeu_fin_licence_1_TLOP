package personnages;

public abstract class AVilain extends APersonnage {
	public AVilain(int niveau, int squarePosX, int squarePosY, MobType mobType) {
        super(niveau, squarePosX, squarePosY, mobType);
        initStats();
	}
	public void initStats() {
		if (getMobType() == MobType.WOLF) {
		  pointsDeVie = (int)100+(21*niveau);
	      pointsDeVieMax = (int) 100+(21*niveau);
	      pointsDAttaque = (int)75+(11*niveau);
	      armure = 0;
		}
	    else if(getMobType() == MobType.SKELETON) {
	    	pointsDeVie = (int) 165+(28*niveau);
	    	pointsDeVieMax = (int) 165+(28*niveau);
	    	pointsDAttaque = (int) 40 +(9*niveau);
	    	armure = 2*niveau;
	    }
	    else if(getMobType() == MobType.ORC) {
	    	pointsDeVie = (int) 250+(43*niveau);
	    	pointsDeVieMax = (int) 250+(43*niveau);
	    	pointsDAttaque = (int) 25+(5*niveau);
	    	armure = 5*niveau;
	    }
	    else if(getMobType() == MobType.BOSS) {
	    	pointsDeVie = 500;
	    	pointsDeVieMax = 500;
	    	pointsDAttaque = 120;
	    	armure = 50;
	    }
	}
}