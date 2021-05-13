package save;

import personnages.*;
import terrain.*;

public class GameSave implements java.io.Serializable {
    private Map map;
    private AHero[] heroes;
    private String worldName;

    public GameSave(Map map, AHero[] heroes, String worldName) {
        this.map = map;
        this.heroes = heroes;
        this.worldName = worldName;
    }

    public Map getMap() {
        return map;
    }

    public AHero[] getHeroes() {
        return heroes;
    }

    public String getWorldName() {
        return worldName;
    }
}