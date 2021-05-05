package untitledgame.terrain;

import java.awt.*;

public enum Direction {
	DOWN("Bas", BorderLayout.NORTH, 0, 1),
	RIGHT("Droite", BorderLayout.EAST, 1, 0),
	UP("Haut", BorderLayout.SOUTH, 0, -1),
    LEFT("Gauche", BorderLayout.WEST, -1, 0);

    public final String label;
    public final String layout;
    public final int x;
    public final int y;

    private Direction(String label, String layout, int x, int y) {
        this.label = label;
        this.layout = layout;
        this.x = x;
        this.y = y;
    }
}