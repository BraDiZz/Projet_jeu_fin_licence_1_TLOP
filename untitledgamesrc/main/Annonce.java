package main;

import java.awt.*;
import javax.swing.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Annonce extends JFrame {
    /**
     * Constructeur par defaut
     */
    public Annonce() {

        JPanel window = new JPanel();
        window.setLayout(new BorderLayout());

        String texte = "<html><h1 style=\"color: yellow;\"align='center'><u>Vous entendez un bruit dans une zone proche !</u></h1>";
        texte += "<br/>";
        texte += "<h3>C'est lui ! Le <i>Golem de magie noire</i> a reconnu votre puissance.<br/>";
        texte += " Prenez garde ! Il est venu spécifiquement pour vous achever. A vous de jouer !</h3></html>";

        JLabel histoire = new JLabel(texte, SwingConstants.CENTER);
        window.add(histoire);
        
        histoire.setOpaque(true);
        histoire.setBackground(Color.BLACK);
        histoire.setForeground(Color.WHITE);

        getContentPane().add(window);

        setSize(1080, 360);
        setLocationRelativeTo(null);
        setTitle("Annonce");
        setVisible(true);
    }
}
