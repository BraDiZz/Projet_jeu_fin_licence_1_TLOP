package untitledgame.objets;
import javax.swing.*;
import java.awt.*;
import untitledgame.texture.Texture;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public abstract class AObjet extends JLabel {
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
    public AObjet(int pvRendus, int xpDonne, ObjetType type) {
        super();
        this.setPreferredSize(new Dimension(53, 53));
        this.pvRendus = pvRendus;
        this.xpDonne = xpDonne;
        this.type = type;
        this.count = 1;
        this.setIcon(new Texture(type));
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

    public boolean addToStack(int add) {
        
    }

    public void paint(Graphics g) {
        g.drawImage(new Texture(type).getImage(), 0, 0, 53, 53, this);
        g.setColor(Color.BLUE);
        g.drawString(Integer.toString(count), 40, 50);
    }
}