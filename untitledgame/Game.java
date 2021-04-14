package untitledgame;

import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
    public Game() {
        setSize(400,200);
	    setLocationRelativeTo(null);
	    setTitle("Game save name");
        setMinimumSize(new Dimension(1280, 720));
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(15, 15));
        grid.setBorder(BorderFactory.createLineBorder(Color.black));

        Chunk test = new Chunk();
        JLabel[][] map = loadChunk(test);

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                grid.add(map[x][y]);
            }
        }

        getContentPane().add(grid);

	    setVisible(true);
    }

    public JLabel[][] loadChunk(Chunk temp) {
        return temp.getContent();
    }
}