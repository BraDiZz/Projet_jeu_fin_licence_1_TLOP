import untitledgame.Game;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import untitledgame.titlescreen.JBackgroundPanel;

public class Main extends JFrame {
    private Image backgroundImage;

    public static void main(String[] args) {
        new Game(10, 10, 123456789l);
        //new Main();
    }

    public Main() {
        setSize(1200,900);
	    setLocationRelativeTo(null);
	    setTitle("Untitled Game");
        setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JBackgroundPanel e = new JBackgroundPanel("assets/titlescreen/title.png");
        setContentPane(e);

        e.setLayout(new FlowLayout());
        e.add(new JLabel("frgzrgzrFEEE"));


        setVisible(true);
    }
}