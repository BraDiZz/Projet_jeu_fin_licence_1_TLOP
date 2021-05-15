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
     * Constructeur par initialisation
     * @param map Map
     * @param heroes AHero[]
     * @param worldName String
     */
    public GameSave(Map map, AHero[] heroes, String worldName) {
        this.map = map;
        this.heroes = heroes;
        this.worldName = worldName;
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
}