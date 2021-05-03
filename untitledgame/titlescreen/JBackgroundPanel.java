package untitledgame.titlescreen;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class JBackgroundPanel extends JPanel {
    private Image img;

    public JBackgroundPanel(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch(IOException err) {
            err.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paint(g);
        g.drawImage(img, 0, 0, this);
    }
}