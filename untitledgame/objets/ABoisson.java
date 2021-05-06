package untitledgame.objets;

public abstract class ABoisson extends AObjet {

	public int xpDonne;
	
	public ABoisson() {
	    xpDonne = 20;
	}

	public int getXpDonne() {
		return xpDonne;
	}

}