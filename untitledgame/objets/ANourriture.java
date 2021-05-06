package untitledgame.objets;

public abstract class ANourriture extends AObjet{
     
    public int pvRendus;

    public ANourriture() {
        pvRendus = 10;
    }    

    public int getPvRendus() {
    	return pvRendus;
    }
}
