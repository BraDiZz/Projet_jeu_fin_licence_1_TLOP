package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Potion extends AObjet {
	/**
	 * Constructeur par defaut
	 */
	public Potion() {
		this(1);
	}
	/**
	 * Constructeur par initialisation
	 * @param count int
	 */
	public Potion(int count) {
	    super(0, 35, count, ObjetType.POTION, 0, 0);
	}
}