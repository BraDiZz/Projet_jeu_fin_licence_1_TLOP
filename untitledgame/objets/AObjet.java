package untitledgame.objets;

public abstract class AObjet {
    private final int pvRendus;
    private final int xpDonne;
    private ObjetType type;
    
    public AObjet(int pvRendus, int xpDonne, ObjetType type) {
        this.pvRendus = pvRendus;
        this.xpDonne = xpDonne;
        this.type = type;
    }

    public int getPvRendus() {
        return pvRendus;
    }

    public int getXpDonne() {
        return xpDonne;
    }

    public ObjetType getType() {
        return type;
    }
}