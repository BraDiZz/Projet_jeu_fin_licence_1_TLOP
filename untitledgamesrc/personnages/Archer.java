package personnages;

public class Archer extends AHero {
	public Archer(String nom, int squarePosX, int squarePosY) {
		super(nom, 250, 250, 60, 10, 1, squarePosX, squarePosY, MobType.ARCHER);
	}
}