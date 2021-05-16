/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
package save;

import personnages.*;
import terrain.*;

public class GameSave implements java.io.Serializable {
    /**
     * Une Map pour la carte
     */
    private Map map;
    /**
     * Un tableau de AHero pour tous les heros jouables par le personnages
     */
    private AHero[] heroes;
    /**
     * Un String pour le nom du monde genere
     */
    private String worldName;
    /**
     * Un int pour le tour entre les differents personnages du joueur
     */
    private int heroTurn;
    /**
     * Un boolean pour si le boss est deja apparue ou pas
     */
    private boolean bossSpawned;
    /**
     * Constructeur par initialisation
     * @param map Map
     * @param heroes AHero[]
     * @param worldName String
     * @param heroTurn int
     * @param bossSpawned boolean
     */
    public GameSave(Map map, AHero[] heroes, String worldName, int heroTurn, boolean bossSpawned) {
        this.map = map;
        this.heroes = heroes;
        this.worldName = worldName;
        this.heroTurn = heroTurn;
        this.bossSpawned = bossSpawned;
    }
    /**
     * Getter de la map
     * @return Map
     */
    public Map getMap() {
        return map;
    }
    /**
     * Getter du tableau des heros
     * @return AHero[]
     */
    public AHero[] getHeroes() {
        return heroes;
    }
    /**
     * Getter pour le nom du monde
     * @return String
     */
    public String getWorldName() {
        return worldName;
    }
    /**
     * Getter du tour du personnage
     * @return int
     */
    public int getHeroTurn() {
        return heroTurn;
    }
    /**
     * Getter pour le boolean de si le boss est deja apparu ou non
     * @return boolean
     */
    public boolean getBossSpawned() {
        return bossSpawned;
    }
}