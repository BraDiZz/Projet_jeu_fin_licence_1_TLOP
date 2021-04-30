package untitledgame.terrain;

import java.awt.*;
import javax.swing.*;

public class Fleche extends javax.swing.JLabel
{
    private String direction;
    private String etat; 
    
    

    public Fleche(String direction)
    {
      
      etat=direction;


    }

    @Override
    public void paint(Graphics g)

  {

    super.paint(g);

    int largeur = (int)getWidth();
    int hauteur = (int)getHeight();


    java.awt.Color couleur_precedente=g.getColor();

    if(etat=="haut")
    {
      g.setColor(Color.magenta);
      g.drawLine(0,hauteur/2,largeur/2,0);
      g.drawLine(largeur/2,0,largeur,hauteur/2);
      
    }

    if(etat=="gauche")
    {
      g.setColor(Color.magenta);
      g.drawLine(largeur/2,0,0,hauteur/2);
      g.drawLine(0,hauteur/2,largeur/2,hauteur);
      
    }

    if(etat=="droite")
    {
      g.setColor(Color.magenta);
      g.drawLine(largeur/2,0,largeur,hauteur/2);
      g.drawLine(largeur,hauteur/2,largeur/2,hauteur);
      
    }

    if(etat=="bas")
    {
      g.setColor(Color.magenta);
      g.drawLine(0,hauteur/2,largeur/2,hauteur);
      g.drawLine(largeur/2,hauteur,largeur,hauteur/2);
      
    }

    g.setColor(couleur_precedente);
    


    /*g.setColor(java.awt.Color.RED);
    g.drawLine(0,0,largeur,hauteur);
    g.drawLine(0,hauteur,largeur,0);

    //g.setColor(java.awt.Color.ORANGE);
    //g.drawOval(0,0,largeur,hauteur);
    */

  }
}