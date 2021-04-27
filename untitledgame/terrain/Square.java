package untitledgame.terrain;

import javax.swing.*;
import java.awt.*;

public class Square extends JLabel {
    public int squarePosX;
    public int squarePosY;
    public String texture;

    public Square(String texture, int chunkPositionX, int chunkPositionY) {
        super();
        Image img = new ImageIcon(texture).getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT);
        this.setIcon(new ImageIcon(img));
        this.squarePosX = squarePosX;
        this.squarePosY = squarePosY;
        this.texture = texture;

    }
    public Square() {
        super(new ImageIcon("assets/textures/terrain/Herbe3.png"));
        this.squarePosX = 0;
        this.squarePosY = 0;
    }

    public int getPosX() {
        return squarePosX;
    }

    public int getPosY() {
        return squarePosY;
    }

    public void setTexture(String texture) {
        this.setIcon(new ImageIcon(texture));
    }

    public String getTexture() {
        return texture;
    }
}