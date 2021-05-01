package untitledgame.terrain;

import javax.swing.*;
import java.awt.*;
import untitledgame.personnages.*;
import untitledgame.texture.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Square extends JLabel {
    private IPersonnage mob;
    private int squarePosX;
    private int squarePosY;
    private Texture texture;

    public Square(Texture texture, int squarePosX, int squarePosY) {
        super();
        this.setPreferredSize(new Dimension(53, 53));
        this.texture = texture;
        this.squarePosX = squarePosX;
        this.squarePosY = squarePosY;
        this.setIcon(texture);
    }

    public Square() {
        this(new Texture(TexturePath.GRASS3), 0, 0);
    }

    public int getPosX() {
        return squarePosX;
    }

    public int getPosY() {
        return squarePosY;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
        repaint();
    }

    public void setMob(IPersonnage mob) {
        this.mob = mob;
    }

    public void paint(Graphics g) {
        g.drawImage(texture.getImage(), 0, 0, 53, 53, this);
        if (mob != null) {
            g.drawImage(mob.getTexture().getImage(), 0, 0, 53, 53, this);
        }
    }
}