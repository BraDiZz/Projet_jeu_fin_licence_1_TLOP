package objets;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import texture.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public abstract class AObjet extends JLabel implements java.io.Serializable {
    /**
     * Un int pour la valeur des PV a regenerer si l'objet est consomme
     */
    private final int pvRendus;
    /**
     * Un int pour la valeur de l'experience gagnee si l'objet est consomme
     */
    private final int xpDonne;
    /**
     * Un ObjetType pour caracteriser le type de l'objet
     */
    private ObjetType type;
    /**
     * Un int pour le nombre d'objet
     */
    private int count;
    /**
     * Un boolean pour savoir si l'item est selectionner ou non
     */
    private boolean isSelected;
    /**
     * Un int pour l'augmentation potentielle de l'attaque
     */
    private int boostAttaque;
    /**
     * Un int pour l'augmentation potentielle de l'armure
     */
    private int boostArmure;
    /**
     * Constructeur par initialisation
     * @param pvRendus int
     * @param xpDonne int
     * @param count int
     * @param type ObjetType
     */
    public AObjet(int pvRendus, int xpDonne, int count, ObjetType type, int boostAttaque, int boostArmure) {
        super();
        this.setPreferredSize(new Dimension(53, 53));
        this.pvRendus = pvRendus;
        this.xpDonne = xpDonne;
        this.type = type;
        this.count = count;
        this.boostAttaque = boostAttaque;
        this.boostArmure = boostArmure;
        try {
            this.setIcon(new Texture(type));
        } catch (IOException e) {
            System.err.println("Texture introuvable : " + e);
        }
    }
    /**
     * Constructeur par initialisation
     * @param pvRendus int
     * @param xpDonne int
     * @param type ObjetType
     */
    public AObjet(int pvRendus, int xpDonne, ObjetType type, int boostAttaque, int boostArmure) {
        this(pvRendus, xpDonne, 1, type, boostAttaque, boostArmure);
    }
    /**
     * Getter pour les PV a regenerer de l'objet
     * @return int
     */
    public int getPvRendus() {
        return pvRendus;
    }
    /**
     * Getter pour l'experience a gagner de l'objet
     * @return int
     */
    public int getXpDonne() {
        return xpDonne;
    }
    /**
     * Getter pour le type de l'objet
     * @return ObjetType
     */
    public ObjetType getType() {
        return type;
    }
    /**
     * Getter pour le nombre d'objet
     * @return
     */
    public int getCount() {
        return count;
    }
    /**
     * Getter pour le boost d'attaque
     * @return int
     */
    public int getBoostAttaque() {
        return boostAttaque;
    }
    /**
     * Getter pour le boost d'armure
     * @return int
     */
    public int getBoostArmure() {
        return boostArmure;
    }
    /**
     * Setter pour le mettre le nombre d'objet en stack de 16
     * @param count int
     */
    public void setStack(int count) {
        this.count = count;
    }
    /**
     * Methode pour ajouter le nombre d'objet qu'il y a dans un stack
     * @param add int
     * @return int
     */
    public int addToStack(int add) {
        int newCount = count + add;
        int remainder = 0;
        if (newCount > 16) {
            remainder = newCount%16 + ((int)(newCount/16)-1) * 16;
            count = 16;
        } else {
            count = newCount;
        }
        return remainder;
    }
    /**
     * Methode pour ajouter un AObjet a un stack
     * @param objet AObjet
     * @return int
     */
    public int addToStack(AObjet objet) {
        int remainder = addToStack(objet.getCount());
        objet.setStack(remainder);
        return objet.getCount();
    }
    /**
     * Methode qui retire un stack de 16
     * @param remove int
     * @return int
     */
    public int removeFromStack(int remove) {
        int remainder = 0;
        count -= remove;
        if (count < 0) {
            remainder = Math.abs(count);
            count = 0;
        }
        return remainder;
    }
    /**
     * Setter de la  variable IsSelected
     * @param isSelected boolean
     */
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    /**
     * Methode pour supprimer un stack entier d'objet
     * @param objet AObjet
     * @return int
     */
    public int removeFromStack(AObjet objet) {
        int remainder = removeFromStack(objet.getCount());
        objet.setStack(remainder);
        return objet.getCount();
    }
    /**
     * Methode qui cree un clone d'un nombre d'objet
     * @param cloneCount int
     * @return AObjet
     */
    public AObjet createClone(int cloneCount) {
        try {
            AObjet clone = getClass().getDeclaredConstructor(int.class).newInstance(cloneCount);
            return clone;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Methode pour changer l'apparence de la texture
     * @param g Graphics
     */
    public void paint(Graphics g) {
        try {
            g.drawImage(new Texture(type).getImage(), 0, 0, 53, 53, this);
        } catch (IOException e) {
            System.err.println("Texture introuvable : " + e);
        } 
        g.setColor(Color.BLUE);
        g.drawString(Integer.toString(count), 40, 50);
        if (isSelected) {
            g.drawOval((getWidth()/2)-20, (getHeight()/2)-20, 40, 40);
        }
    }
}