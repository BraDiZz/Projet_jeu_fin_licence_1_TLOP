package untitledgame.terrain;

import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
    public Game() {
        setSize(500,500);
	    setLocationRelativeTo(null);
	    setTitle("Game save name");
        setPreferredSize(new Dimension(2, 2));
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(15, 15));

        Chunk test = new Chunk();
        Square[][] map = loadChunk(test);

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                grid.add(map[x][y]);
            }
        }

        getContentPane().add(grid);

	    setVisible(true);
    }

    public Square[][] loadChunk(Chunk temp) {
        return temp.getContent();
    }
}