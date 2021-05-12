package personnages;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 11/05/2021
 */
public class Boss extends AVilain {
    /**
     * Constructeur par defaut
     * @param niveau int
     * @param squarePosX int 
     * @param squarePosY int
     */
    public Boss(int niveau, int squarePosX, int squarePosY) {
        super(niveau, squarePosX, squarePosY, MobType.BOSS);
        initStats();
    }
}