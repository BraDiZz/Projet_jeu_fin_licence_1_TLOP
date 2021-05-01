package untitledgame.personnages;

public abstract class AVilain extends APersonnage {
	public AVilain() {
                super();
	}

	public AVilain(int pointsDeVie, int pointsDeVieMax, int pointsDAttaque, int armure, int armureMax, int niveau) {
                super(pointsDeVie,pointsDeVieMax,pointsDAttaque,armure,armureMax,niveau);		
	}
    public void changeStats() {

        int niveau = getNiveau();
        // le ratio represente l'amelioration a apporter en pourcentage
        int ratio = 10;
        int pvARajouter = (int)(getPointsDeVie()*ratio/100);
        int pvMaxARajouter = (int)(getPointsDeVieMax()*ratio/100);
        int armureARajouter = (int)(getArmure()*ratio/100);
        int armureMaxARajouter = (int)(getArmureMax()*ratio/100);
        int degatsARajouter = (int)(getPointsDAttaque()*ratio/100);

        setPointsDeVie(pvARajouter);
        setPointsDeVieMax(pvMaxARajouter);
        setArmure(armureARajouter);
        setArmureMax(armureMaxARajouter);
        setPointsDAttaque(degatsARajouter);
    }
}
	
