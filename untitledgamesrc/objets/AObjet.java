package objets;
import javax.swing.*;
import java.awt.*;
import texture.Texture;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
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
    private int count;
    /**
     * Constructeur par initialisation
     * @param pvRendus int
     * @param xpDonne int
     * @param type ObjetType
     */
    public AObjet(int pvRendus, int xpDonne, int count, ObjetType type) {
        super();
        this.setPreferredSize(new Dimension(53, 53));
        this.pvRendus = pvRendus;
        this.xpDonne = xpDonne;
        this.type = type;
        this.count = count;
        this.setIcon(new Texture(type));
    }

    public AObjet(int pvRendus, int xpDonne, ObjetType type) {
        this(pvRendus, xpDonne, 1, type);
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

    public int getCount() {
        return count;
    }

    public void setStack(int count) {
        this.count = count;
    }

    public int addToStack(int add) {
        int newCount = count + add;
        int remainder = 0;
        if (newCount > 16) {
            remainder = newCount%16;
            count = 16;
        } else {
            count = newCount;
        }
        return remainder;
    }

    public int addToStack(AObjet objet) {
        int remainder = addToStack(objet.getCount());
        objet.setStack(remainder);
        return objet.getCount();
    }

    public int removeFromStack(int remove) {
        int remainder = 0;
        count -= remove;
        if (count < 0) {
            remainder = Math.abs(count);
            count = 0;
        }
        return remainder;
    }

    public int removeFromStack(AObjet objet) {
        int remainder = removeFromStack(objet.getCount());
        objet.setStack(remainder);
        return objet.getCount();
    }

    public void paint(Graphics g) {
        g.drawImage(new Texture(type).getImage(), 0, 0, 53, 53, this);
        g.setColor(Color.BLUE);
        g.drawString(Integer.toString(count), 40, 50);
    }
}