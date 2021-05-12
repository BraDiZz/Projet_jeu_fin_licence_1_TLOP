package gamegui;

import java.awt.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public class Fleche extends javax.swing.JLabel
{
  /**
   * Un String pour connaitre la direction de la fleche cliquee
   */
  private String direction;
  /**
   * Un String pour connaitre l'etat de la fleche
   */
  private String etat; 
  /**
   * Un boolean pour savoir si la fleche est cliquee ou non
   */
  private boolean clique;
  /**
   * Constructeur par initialisation
   * @param direction String
   */
  public Fleche(String direction) {
    etat=direction;
  }
  /**
   * Setter qui change la valeur du clique
   * @param clique boolean
   */
  public void clique(boolean clique) {
    this.clique=clique;
  }
  /**
   * Methode pour changer l'apparence des boutons de deplacement
   * @param g Graphics
   */
  @Override
  public void paint(Graphics g) {
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