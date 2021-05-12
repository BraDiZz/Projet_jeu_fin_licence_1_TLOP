package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public class Pomme extends AObjet {
	/**
	 * Constructeur par defaut
	 */
	public Pomme() {
		this(1);
	}

	public Pomme(int count) {
		super(10, 0, count, ObjetType.POMME);
	}
}
