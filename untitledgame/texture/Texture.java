package untitledgame.texture;

import untitledgame.terrain.SquareType;
import untitledgame.personnages.MobType;
import untitledgame.objets.ObjetType;

import javax.swing.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public class Texture extends ImageIcon {
    /**
     * Un SquareType pour la texture du Square
     */
    private SquareType textureName;
    /**
     * Un MobType pour la texture du Mob
     */
    private MobType mobName;
    /**
     * Un ObjetType pour la texture de l'objet
     */
    private ObjetType objetName;
    /**
     * Constructeur par initialisation
     * @param textureName SquareType
     */
    public Texture(SquareType textureName) {
        super(textureName.path);
        this.textureName = textureName;
    }
    /**
     * Constructeur par initialisation
     * @param mobName MobType
     */
    public Texture(MobType mobName) {
        super(mobName.path);
        this.mobName = mobName;
    }
    /**
     * Constructeur par initialisation
     * @param objetName ObjetType
     */
    public Texture(ObjetType objetName) {
        super(objetName.path);
        this.objetName = objetName;
    }
    /**
     * Getter pour le nom de la texture du Square
     * @return SquareType
     */
    public SquareType getTextureName() {
        return textureName;
    }
}