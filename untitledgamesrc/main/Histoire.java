package main;

import java.awt.*;
import javax.swing.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Histoire extends JFrame {
    /**
     * Constructeur par defaut
     */
    public Histoire() {

        JPanel window = new JPanel();
        window.setLayout(new BorderLayout());

        String texte = "<html><h1 style=\"color: yellow;\"align='center'><u>Message du Roi</u></h1>";
        texte += "<br/>";
        texte += "<h3>&#9Bonjour aventurier, le royaume est accul&eacute; par nos ennemis de toujours : <b>Les Darkins !</b></h3><br/>";
        texte += "<h3>&#9Je demande donc votre aide pour nous aider &agrave; les vaincre et sauver le royaume. ";
        texte += "Prenez garde aux <i>Squelettes</i>, ils ont peut-&ecirc;tre l'air faible mais leur polyvalence vous surprendra ";
        texte += "s&ucirc;rement ! Les <i>Orcs</i> sont lourdement arm&eacute;s et ne pourront pas &ecirc;tre vaincu d'un simple";
        texte += " coup d'&eacute;p&eacute;e. Les <i>Loups</i> ont des crocs d'acier et une simple de leur morsure peut ";
        texte += "neutraliser un soldat aguerri ! Et enfin, le pire de tous les ennemis, leur leader : nous ";
        texte += "l'avons nomm&eacute; le <i>Golem de magie noir</i>. Une fois ce dernier ennemi vaincu, le reste ";
        texte += "des troupes fuieront.</h3><br/>";
        texte += "<h3>&#9Bonne chance aventurier, le destin du royaume est entre vos mains !</h3>";
        texte += "<h2 style=\"color: yellow;\"align='center'><u>Le Roi Perlin</u></h2></html>";

        JLabel histoire = new JLabel(texte);
        window.add(histoire);
        
        histoire.setOpaque(true);
        histoire.setBackground(Color.BLACK);
        histoire.setForeground(Color.WHITE);

        getContentPane().add(window);

        setSize(1080, 360);
        setLocationRelativeTo(null);
        setTitle("Message du roi");
        setVisible(true);
    }
}
