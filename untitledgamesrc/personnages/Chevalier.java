package personnages;

public class Chevalier extends AHero {
	public Chevalier(String nom, int squarePosX, int squarePosY) {
		super(nom, 300, 300, 20, 17, 1, squarePosX, squarePosY, MobType.KNIGHT);
	}
}