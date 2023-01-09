package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Pomme extends AObjet {
	/**
	 * Constructeur par defaut
	 */
	public Pomme() {
		this(1);
	}
	/**
	 * Constructeur par initialisation
	 * @param count int
	 */
	public Pomme(int count) {
		super(30, 0, count, ObjetType.POMME, 0, 0);
	}
}
