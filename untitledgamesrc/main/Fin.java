package main;

import javax.swing.*;
import java.awt.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Fin extends JFrame {
    /**
     * Constructeur par defaut
     */
    public Fin() {
        JPanel window = new JPanel();
        window.setLayout(new BorderLayout());

        String texte = "<html><h1 style=\"color: yellow;\"align='center'><u>Message du Roi</u></h1>";
        texte += "<br/>";
        texte += "<h3>&#9Bonjour aventurier, le <i>Golem de magie noir</i> a &eacute;t&eacute; vaincu !<br/>";
        texte += "&#9Les troupes ennemies battent en retraite, vous les avez vaincu !<br/>";
        texte += "&#9Je ne serai jamais assez reconnaissant de ce que vous avez fait pour tous les habitants du royaume. <br/>";
        texte += "Une statue sera &eacute;rig&eacute;e &agrave; la capitale en guise de remerciement et de votre courage. <br/>";
        texte += "Vous serez &eacute;galement couvert d'or et une maison &agrave; la capitale vous sera offerte.<br/>";
        texte += "<br/>";
        texte += "&#9Encore une fois, merci aventurier pour votre devouement !</h3>";
        texte += "<h2 style=\"color: yellow;\"align='center'><u>Le Roi Perlin</u></h2></html>";

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
