package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Chevalier extends AHero {
	/**
	 * Constructeur par initialisation
	 * @param nom String
	 * @param squarePosX int
	 * @param squarePosY int
	 */
	public Chevalier(String nom, int squarePosX, int squarePosY) {
		super(nom, 350, 350, 25, 17, 1, squarePosX, squarePosY, MobType.KNIGHT);
	}
}