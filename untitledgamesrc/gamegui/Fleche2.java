package gamegui;

import java.awt.*;
import javax.swing.*;
import terrain.Direction;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public class Fleche2 extends JLabel {
    /**
     * Un int pour la position sur l'axe X
     */
    private int x;
    /**
     * Un int pour la position sur l'axe Y
     */
    private int y;
    /**
     * Constructeur par initialisation
     * @param direction Direction
     */
    public Fleche2(Direction direction) {
        this.x = direction.x;
        this.y = direction.x == 0 ? -1*direction.y : direction.y;
        this.setPreferredSize(new Dimension(50, 50));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    /**
     * Methode pour changer l'apparence du component
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(x < 0 ? Math.asin(y)+Math.PI : Math.asin(y), getWidth()/2, getHeight()/2);
        g2d.drawLine(getWidth()/2, 50, getWidth(), getHeight()/2);
    }
}