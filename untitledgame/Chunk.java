package untitledgame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Chunk {
    private JLabel[][] content;

    public Chunk() {
        content = new JLabel[15][15];
        fillWithGrass();
        addStone();
    }

    public JLabel[][] getContent() {
        return content;
    }

    public JLabel getContentAtPos(int x, int y) {
        return content[x][y];
    }

    public void fillWithGrass() {
        ImageIcon texture = new ImageIcon("assets/textures/terrain/grass.png");
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                JLabel grass = new JLabel(texture);
                content[x][y] = grass;
            }
        }
    }

    public void addStone() {
        ImageIcon texture = new ImageIcon("assets/textures/terrain/stone.png");
        for (int x = 0; x < 6; x++) {
            JLabel stone = new JLabel(texture);
            System.out.println(stone.getWidth());
            content[(int)(Math.random()*content.length)][(int)(Math.random()*content.length)] = stone;
        }
    }
}