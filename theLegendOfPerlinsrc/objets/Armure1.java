package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Armure1 extends AObjet {
    /**
     * Constructeur par defaut
     */
    public Armure1() {
        this(1);
    }
    /**
     * Constructeur par initialisation
     * @param count int
     */
    public Armure1(int count) {
        super(0, 0, count, ObjetType.ARMURE1, 0, 5);
    }
}
