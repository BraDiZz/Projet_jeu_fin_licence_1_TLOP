package texture;

import terrain.SquareType;
import personnages.MobType;
import objets.ObjetType;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
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
    public Texture(SquareType textureName) throws IOException {
        super(ImageIO.read(Texture.class.getResourceAsStream(textureName.path)));
        this.textureName = textureName;
    }
    /**
     * Constructeur par initialisation
     * @param mobName MobType
     */
    public Texture(MobType mobName) throws IOException {
        super(ImageIO.read(Texture.class.getResourceAsStream(mobName.path)));
        this.mobName = mobName;
    }
    /**
     * Constructeur par initialisation
     * @param objetName ObjetType
     */
    public Texture(ObjetType objetName) throws IOException {
        super(ImageIO.read(Texture.class.getResourceAsStream(objetName.path)));
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