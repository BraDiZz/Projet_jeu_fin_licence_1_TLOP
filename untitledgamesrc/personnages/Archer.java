package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Archer extends AHero {
	/**
	 * Constructeur par initialisation
	 * @param nom String
	 * @param squarePosX int
	 * @param squarePosY int
	 */
	public Archer(String nom, int squarePosX, int squarePosY) {
		super(nom, 220, 220, 50, 15, 1, squarePosX, squarePosY, MobType.ARCHER);
	}
}