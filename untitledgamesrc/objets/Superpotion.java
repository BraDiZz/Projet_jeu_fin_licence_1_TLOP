package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 12/05/2021
 */
public class Superpotion extends AObjet {
	/**
	 * Constructeur par defaut
	 */
	public Superpotion() {
		this(1);
	}
	/**
	 * Constructeur par initialisation
	 * @param count int
	 */
	public Superpotion(int count) {
	    super(0, 60, count, ObjetType.SUPERPOTION);
	}
}