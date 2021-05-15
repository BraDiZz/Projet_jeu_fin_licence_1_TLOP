package terrain;

import java.awt.*;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 * Enumeration pour les fleches
 * {@link #DOWN}
 * {@link #RIGHT}
 * {@link #UP
 * {@link #LEFT}
 */
public enum Direction {
    /**
     * Direction pour le bas
     */
	DOWN("Bas", BorderLayout.SOUTH, 0, 1),
    /**
     * Direction pour la droite
     */
	RIGHT("Droite", BorderLayout.EAST, 1, 0),
    /**
     * Direction pour le haut
     */
	UP("Haut", BorderLayout.NORTH, 0, -1),
    /**
     * Direction pour la gauche
     */
    LEFT("Gauche", BorderLayout.WEST, -1, 0);
    /**
     * Un string pour le nom du label
     */
    public final String label;
    /**
     * Un String pour ???
     */
    public final String layout;
    /**
     * Un int pour la position en X de la fleche
     */
    public final int x;
    /**
     * Un int pour la position en Y de la fleche
     */
    public final int y;
    /**
     * Constructeur par initialisation
     * @param label String
     * @param layout String
     * @param x int
     * @param y int
     */
    private Direction(String label, String layout, int x, int y) {
        this.label = label;
        this.layout = layout;
        this.x = x;
        this.y = y;
    }
}