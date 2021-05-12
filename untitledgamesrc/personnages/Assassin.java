package personnages;

public class Assassin extends AHero {
	public Assassin(String nom, int squarePosX, int squarePosY) {
	   super(nom, 150, 150, 90, 0, 1, squarePosX, squarePosY, MobType.MURDERER);
	}
}