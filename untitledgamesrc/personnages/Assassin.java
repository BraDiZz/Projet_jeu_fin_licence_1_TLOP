package personnages;

public class Assassin extends AHero {
	public Assassin(String nom, int squarePosX, int squarePosY) {
	   super(nom, 170, 170, 90, 0, 1, squarePosX, squarePosY, MobType.MURDERER);
	}
}