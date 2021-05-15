package objets;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Armure3 extends AObjet {
    /**
     * Constructeur par defaut
     */
    public Armure3() {
        this(1);
    }
    /**
     * Constructeur par initialisation
     * @param count int
     */
    public Armure3(int count) {
        super(0, 0, count, ObjetType.ARMURE3);
    }
}