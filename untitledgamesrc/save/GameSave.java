package save;

import personnages.*;
import terrain.*;

public class GameSave implements java.io.Serializable {
    private Map map;
    private AHero[] heroes;
    private String worldName;
    private int heroTurn;

    public GameSave(Map map, AHero[] heroes, String worldName, int heroTurn) {
        this.map = map;
        this.heroes = heroes;
        this.worldName = worldName;
        this.heroTurn = heroTurn;
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

    public int getHeroTurn() {
        return heroTurn;
    }
}