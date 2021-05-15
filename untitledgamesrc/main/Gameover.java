package main;

import javax.swing.*;
import java.awt.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Gameover extends JFrame {
    /**
     * Constructeur par defaut
     */
    public Gameover() {
        JPanel window = new JPanel();
        window.setLayout(new BorderLayout());

        String texte = "<html><h1 style=\"color: yellow;\"align='center'><u>GAME OVER</u></h1>";
        texte += "<br/>";
        texte += "<h3>Oh non ! Le <i>Golem de magie noir</i>  n'a pas &eacute;t&eacute; vaincu !<br/>";
        texte += "Les troupes ennemies ont mit fin a vos jours..<br/>";
        texte += "Malheureusement l'aventure s'arrete la pour vous...<br/>";
        texte += "Nous comptons sur vous pour revenir plus fort..";

        JLabel messageFinal = new JLabel(texte, SwingConstants.CENTER);
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
