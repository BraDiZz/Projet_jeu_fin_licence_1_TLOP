package untitledgame.titlescreen;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class JBackgroundPanel extends JPanel {
    private Image img;

    public JBackgroundPanel(String path, LayoutManager layout) {
        try {
            img = ImageIO.read(new File(path));
        } catch(IOException err) {
            err.printStackTrace();
        }
        this.setLayout(layout);
        this.setSize(img.getWidth(this), img.getHeight(this));
        this.setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
    }

    public JBackgroundPanel(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch(IOException err) {
            err.printStackTrace();
        }
        this.setSize(img.getWidth(this), img.getHeight(this));
        this.setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
    }

    public void setRatio(double x) {
        try {
            if (x <= 0 ) {
                throw new IllegalArgumentException("Ratio must be bigger than 0.");
            }            
            this.setSize((int)(img.getWidth(this)*x), (int)(img.getHeight(this)*x));
            this.setPreferredSize(new Dimension((int)(img.getWidth(this)*x), (int)(img.getHeight(this)*x)));
        } catch (IllegalArgumentException err) {
            err.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}