package untitledgame.terrain;

import javax.swing.*;
import java.awt.*;

public class Square extends JLabel {
    public int chunkPositionX;
    public int chunkPositionY;

    public Square(String texture, int chunkPositionX, int chunkPositionY) {
        super();
        Image img = new ImageIcon(texture).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        this.setIcon(new ImageIcon(img));
        this.chunkPositionX = chunkPositionX;
        this.chunkPositionY = chunkPositionY;

    }
    public Square() {
        super(new ImageIcon("assets/textures/terrain/grass.png"));
        this.chunkPositionX = 0;
        this.chunkPositionY = 0;
    }

    public int getPosX() {
        return chunkPositionX;
    }

    public int getPosY() {
        return chunkPositionY;
    }
}