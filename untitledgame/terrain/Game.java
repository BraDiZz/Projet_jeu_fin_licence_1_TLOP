package untitledgame.terrain;

import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
    private JPanel grid = new JPanel();
    private Map map;
    private int curDisX = 0;
    private int curDisY = 0;

    public Game(int mapSize, long seed) {
        setSize(1200,900);
	    setLocationRelativeTo(null);
	    setTitle("Game save name");
        setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        map = new Map(mapSize, mapSize, seed);
        
        JPanel mainWindow = new JPanel();
        mainWindow.setLayout(new FlowLayout());

        grid.setLayout(new GridLayout(15, 15));
        
        loadChunk(map.getChunkAtPos(curDisX, curDisY));

        JPanel directions = new JPanel();
        String[] directionsString = {"Bas", "Droite", "Haut", "Gauche"};
        directions.setLayout(new FlowLayout());
        for (int i = 0; i < 4; i++) {
            JButton direction = new JButton(directionsString[i]);
            direction.addActionListener(new ChangeMapButton(i));
            directions.add(direction);
        }

        mainWindow.add(grid);
        mainWindow.add(directions);

        getContentPane().add(mainWindow);

	    setVisible(true);
    }

    public void loadChunk(Chunk chunk) {
        grid.removeAll();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                grid.add(chunk.getContentAtPos(x, y));
            }
        }
        grid.validate();
        grid.repaint();
    }

    public void changeMapChunk(Map map, int direction) {
        switch (direction) {
            case 0:
                if (curDisX < map.getSizeX()-1) {
                    curDisX++;
                }
                break;
            case 1:
                if (curDisY < map.getSizeY()-1) {
                    curDisY++;
                }
                break;
            case 2:
                if (curDisX > 0) {
                    curDisX--;
                }
                break;
            case 3:
                if (curDisY > 0) {
                    curDisY--;
                }
                break;
        }
        System.out.println(curDisX + " " + curDisY);
        loadChunk(map.getChunkAtPos(curDisX, curDisY));
    }

    class ChangeMapButton implements java.awt.event.ActionListener {
        private int direction;

        public ChangeMapButton(int direction) {
            this.direction = direction;
        }

        public void actionPerformed(java.awt.event.ActionEvent ev) {
            changeMapChunk(map, direction);
        }
    }
}