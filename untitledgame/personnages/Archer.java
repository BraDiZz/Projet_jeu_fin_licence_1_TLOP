package untitledgame.personnages;

public class Archer extends AHero {
	
	public Archer() {
		super(200, 200, 60, 10, 25, 1);
		setNom("Archer");
	}
	public Archer(String nom) {
		super(200, 200, 60, 10, 25, 1);
		setNom(nom);
	}
}