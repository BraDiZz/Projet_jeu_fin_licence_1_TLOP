package terrain;

import javax.swing.*;
import java.awt.*;
import personnages.*;
import texture.*;
/**
 * @author
 * @version 10/05/2021
 */
public class Square extends JLabel implements java.io.Serializable {
    /**
     * Un int pour la position du Square aux coordonnees X
     */
    private int squarePosX;
    /**
     * Un int pour la position du Square aux coordonnees Y
     */
    private int squarePosY;
    /**
     * Un SquareType afin de connaitre quoi compose la case
     */
    private SquareType squareType;
    /**
     * Un APersonnage afin de connaitre le type du personnage
     */
    private APersonnage mob;
    /**
     * Un boolean qui indique si le joueur est proche de la case
     */
    private boolean isSelected = false;
    /**
     * Constructeur par initialisation
     * @param squareType SquareType 
     * @param squarePosX int 
     * @param squarePosY int 
     */
    public Square(SquareType squareType, int squarePosX, int squarePosY) {
        super();
        this.setPreferredSize(new Dimension(53, 53));
        this.squareType = squareType;
        this.squarePosX = squarePosX;
        this.squarePosY = squarePosY;
        this.setIcon(new Texture(squareType));
    }
    /**
     * Constructeur par defaut
     */
    public Square() {
        this(SquareType.GRASS3, 0, 0);
    }
    /**
     * Getter pour la position a la coordonnee X
     * @return int
     */
    public int getPosX() {
        return squarePosX;
    }
    /**
     * Getter pour la position a la coordonnee Y
     * @return int
     */
    public int getPosY() {
        return squarePosY;
    }
    /**
     * Getter pour le type du Square
     * @return SquareType
     */
    public SquareType getSquareType() {
        return squareType;
    }
    /**
     * Setter pour changer le type du Square et de le repaint() derriere
     * @param squareType Squaretype
     */
    public void setSquareType(SquareType squareType) {
        this.squareType = squareType;
        repaint();
    }
    /**
     * Setter pour placer un personnage sur le Square
     * @param mob APersonnage
     */

    public void setMob(APersonnage mob) {
        this.mob = mob;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    /**
     * Getter qui renvoie le mob sur le Square
     * @return mob
    */
    public APersonnage getMob() {
        return mob;
    }
    /**
     * Méthode pour vérifier si le Square est valide
     * @return un booléen
     */
    public boolean isSpawnValid() {
        return (mob == null && !squareType.hasBoundingBox);
    }

    /**
     * Methode pour changer l'apparence du Square
     * @param g Graphics
     */
    public void paint(Graphics g) {
        g.drawImage(new Texture(squareType).getImage(), 0, 0, 53, 53, this);
        if (mob != null) {
            g.drawImage(new Texture(mob.getMobType()).getImage(), 0, 0, 53, 53, this);
        }
        if (isSelected) {
            g.drawRect((getWidth()/2)-20, (getHeight()/2)-20, 40, 40);
        }
    }
}