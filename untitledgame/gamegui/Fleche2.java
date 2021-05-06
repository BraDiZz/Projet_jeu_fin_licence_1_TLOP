package untitledgame.gamegui;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import untitledgame.terrain.Direction;

public class Fleche2 extends JLabel {
    private int x;
    private int y;

    public Fleche2(Direction direction) {
        this.x = direction.x;
        this.y = direction.x == 0 ? -1*direction.y : direction.y;
        this.setPreferredSize(new Dimension(50, 50));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(x < 0 ? Math.asin(y)+Math.PI : Math.asin(y), getWidth()/2, getHeight()/2);
        g2d.drawLine(getWidth()/2, 50, getWidth(), getHeight()/2);
    }
}