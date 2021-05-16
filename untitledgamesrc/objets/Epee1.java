package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Epee1 extends AObjet {
    /**
     * Constructeur par defaut
     */
    public Epee1() {
        this(1);
    }
    /**
     * Constructeur par initialisation
     * @param count int
     */
    public Epee1(int count) {
        super(0, 0, count, ObjetType.EPEE1, 5, 0);
    }
}
