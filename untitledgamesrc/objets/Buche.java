package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Buche extends AObjet {
    /**
     * Constructeur par defaut
     */
    public Buche() {
        this(1);
    }
    /**
     * Constructeur par initialisation
     * @param count int
     */
    public Buche(int count) {
        super(0, 0, count, ObjetType.BUCHE, 0, 0);
    }
}