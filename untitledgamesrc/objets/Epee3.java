package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Epee3 extends AObjet {
    /**
     * Constructeur par defaut
     */
    public Epee3() {
        this(1);
    }
    /**
     * Constructeur par initialisation
     * @param count int
     */
    public Epee3(int count) {
        super(0, 0, count, ObjetType.EPEE3, 25, 0);
    }
}