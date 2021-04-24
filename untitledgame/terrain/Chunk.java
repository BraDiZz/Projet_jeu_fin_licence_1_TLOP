package untitledgame.terrain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Chunk {
    private Square[][] content;

    public Chunk() {
        content = new Square[15][15];
        fillWithGrass();
        addStonePatches();
    }

    public Square[][] getContent() {
        return content;
    }

    public Square getContentAtPos(int x, int y) {
        return content[x][y];
    }

    public void fillWithGrass() {
        String texture = "assets/textures/terrain/grass.png";
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                Square grass = new Square(texture, x, y);
                content[x][y] = grass;
            }
        }
    }

    public void addStonePatches() {
        String texture = "assets/textures/terrain/stone.png";
        for (int x = 0; x < 6; x++) {
            int[] randPos = {(int)(Math.random()*content.length), (int)(Math.random()*content.length)};
            Square stone = new Square(texture, randPos[0], randPos[1]);
            content[randPos[0]][randPos[1]] = stone;
        }
    }
}