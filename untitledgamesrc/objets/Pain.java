package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 12/05/2021
 */
public class Pain extends AObjet {
    /**
     * Constructeur par defaut
     */
    public Pain() {
        this(1);
    }
    /**
     * Constructeur par initialisation
     * @param count int
     */
    public Pain(int count) {
    	super(20, 0, count, ObjetType.PAIN);
    }
}