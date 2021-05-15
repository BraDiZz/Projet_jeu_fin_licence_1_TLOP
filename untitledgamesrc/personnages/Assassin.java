package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Assassin extends AHero {
	/**
	 * Constructeur par initialisation
	 * @param nom String
	 * @param squarePosX int
	 * @param squarePosY int
	 */
	public Assassin(String nom, int squarePosX, int squarePosY) {
	   super(nom, 170, 170, 90, 0, 1, squarePosX, squarePosY, MobType.MURDERER);
	}
}