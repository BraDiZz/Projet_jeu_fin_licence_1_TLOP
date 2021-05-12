package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 11/05/2021
 */
public class Orc extends AVilain {
    /**
     * Constructeur par defaut
     * @param niveau int
     * @param squarePosX int 
     * @param squarePosY int
     */
    public Orc(int niveau, int squarePosX, int squarePosY) {
        super(niveau, squarePosX, squarePosY, MobType.ORC);
        initStats();
    }
}
