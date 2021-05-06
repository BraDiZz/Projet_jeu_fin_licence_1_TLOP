package untitledgame.terrain;

import javax.swing.*;
import java.awt.*;
import untitledgame.personnages.*;
import untitledgame.texture.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Square extends JLabel {
    private int squarePosX;
    private int squarePosY;
    private SquareType squareType;
    private APersonnage mob;

    public Square(SquareType squareType, int squarePosX, int squarePosY) {
        super();
        this.setPreferredSize(new Dimension(53, 53));
        this.squareType = squareType;
        this.squarePosX = squarePosX;
        this.squarePosY = squarePosY;
        this.setIcon(new Texture(squareType));
    }

    public Square() {
        this(SquareType.GRASS3, 0, 0);
    }

    public int getPosX() {
        return squarePosX;
    }

    public int getPosY() {
        return squarePosY;
    }

    public SquareType getSquareType() {
        return squareType;
    }

    public void setSquareType(SquareType squareType) {
        this.squareType = squareType;
        repaint();
    }

    public void setMob(APersonnage mob) {
        this.mob = mob;
    }

    public void paint(Graphics g) {
        g.drawImage(new Texture(squareType).getImage(), 0, 0, 53, 53, this);
        if (mob != null) {
            g.drawImage(new Texture(mob.getMobType()).getImage(), 0, 0, 53, 53, this);
        }
    }
}