package untitledgame.personnages;

public class Chevalier extends AHero {
	public Chevalier(String nom, int squarePosX, int squarePosY) {
		super(nom, 300, 300, 40, 20, 1, squarePosX, squarePosY, MobType.KNIGHT);
	}
}