package main;

import javax.swing.*;
import java.awt.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 12/05/2021
 */
public class Fin extends JFrame {

    public Fin() {
        JPanel window = new JPanel();
        window.setLayout(new BorderLayout());

        String texte = "<html><h1 style=\"color: yellow;\"align='center'><u>Message du Roi</u></h1>";
        texte += "<br/>";
        texte += "<h2 style=\"color: yellow;\"align='center'><u>Le Roi Perlin</u></h2></html>";

        JLabel messageFinal = new JLabel(texte);
        window.add(messageFinal);
        
        messageFinal.setOpaque(true);
        messageFinal.setBackground(Color.BLACK);
        messageFinal.setForeground(Color.WHITE);

        getContentPane().add(window);

        setSize(1080, 360);
        setLocationRelativeTo(null);
        setTitle("Message du roi");
        setVisible(true);
    }    
}
