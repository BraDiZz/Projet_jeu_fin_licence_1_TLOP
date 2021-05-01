package untitledgame.personnages;

public class Chevalier extends AHero {

	public Chevalier() {
		super();
		setNom("Chevalier");
	}
	public Chevalier(String nom) {
		super(300,300,40,20,50,1);
		setNom(nom);
	}
}