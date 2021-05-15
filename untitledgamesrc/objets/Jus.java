package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Jus extends AObjet {
	/**
	 * Constructeur par defaut
	 */
	public Jus() {
		this(1);
	}
	/**
	 * Constructeur par initialisation
	 * @param count int
	 */
	public Jus(int count) {
	   super(0, 20, count, ObjetType.JUS);
	}
}