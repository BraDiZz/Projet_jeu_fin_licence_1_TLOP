package untitledgame.terrain;

import javax.swing.*;
import java.awt.*;
import untitledgame.personnages.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Square extends JLabel {
    private IPersonnage mob;
    private int squarePosX;
    private int squarePosY;
    private String texture;

    public Square(String texture, int squarePosX, int squarePosY) {
        super();
        Image img = new ImageIcon(texture).getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT);
        this.setIcon(new ImageIcon(img));
        this.squarePosX = squarePosX;
        this.squarePosY = squarePosY;
        this.texture = texture;
    }

    public Square() {
        this("assets/textures/terrain/Herbe3.png", 0, 0);
    }

    public int getPosX() {
        return squarePosX;
    }

    public int getPosY() {
        return squarePosY;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
        repaint();
    }

    public void setMob(IPersonnage mob) {
        this.mob = mob;
    }

    public void paint(Graphics g) {
        g.drawImage(new ImageIcon(texture).getImage(), 0, 0, 53, 53, this);
        try {
            if (mob != null) {
                g.drawImage(ImageIO.read(new File(mob.getSquare().getTexture())), 0, 0, 53, 53, this);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}