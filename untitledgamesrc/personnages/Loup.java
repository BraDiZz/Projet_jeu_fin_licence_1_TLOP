package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public class Loup extends AVilain {
    /**
     * Constructeur par initialisation
     * @param niveau int
     * @param squarePosX int 
     * @param squarePosY int
     */
    public Loup(int niveau, int squarePosX, int squarePosY) {
    	super(niveau, squarePosX, squarePosY, MobType.WOLF);
    }
}