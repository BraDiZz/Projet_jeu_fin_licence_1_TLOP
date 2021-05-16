package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Epee2 extends AObjet {
    /**
     * Constructeur par defaut
     */
    public Epee2() {
        this(1);
    }
    /**
     * Constructeur par initialisation
     * @param count int
     */
    public Epee2(int count) {
        super(0, 0, count, ObjetType.EPEE2, 10, 0);
    }
}