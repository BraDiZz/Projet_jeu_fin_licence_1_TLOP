package untitledgame.gamegui;

import java.awt.*;
import javax.swing.*;

public class Fleche extends javax.swing.JLabel
{
    private String direction;
    private String etat; 
    private boolean clique;
    

    public Fleche(String direction)
    {
      
      etat=direction;


    }

    public void clique(boolean clique){
      this.clique=clique;
    }

   

    @Override
    public void paint(Graphics g)

  {

    super.paint(g);

    int largeur = (int)getWidth();
    int hauteur = (int)getHeight();
  
    g.setColor(new Color(255,0,251));

    if(clique==true){
      g.setColor(Color.cyan);
    }

    if(etat=="haut")
    {
      g.drawLine(0,hauteur/2,largeur/2,0);
      g.drawLine(largeur/2,0,largeur,hauteur/2);
    }

    if(etat=="gauche")
    {
      g.drawLine(largeur/2,0,0,hauteur/2);
      g.drawLine(0,hauteur/2,largeur/2,hauteur);
    }

    if(etat=="droite")
    {
      g.drawLine(largeur/2,0,largeur,hauteur/2);
      g.drawLine(largeur,hauteur/2,largeur/2,hauteur);
    }

    if(etat=="bas")
    {
      g.drawLine(0,hauteur/2,largeur/2,hauteur);
      g.drawLine(largeur/2,hauteur,largeur,hauteur/2);
    }
    

    
    


    /*g.setColor(java.awt.Color.RED);
    g.drawLine(0,0,largeur,hauteur);
    g.drawLine(0,hauteur,largeur,0);

    //g.setColor(java.awt.Color.ORANGE);
    //g.drawOval(0,0,largeur,hauteur);
    */

  }
}