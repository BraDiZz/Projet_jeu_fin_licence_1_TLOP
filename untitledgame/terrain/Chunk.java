package untitledgame.terrain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Chunk {
    private int chunkPosX;
    private int chunkPosY;
    private Square[][] content;

    public Chunk(int chunkPosX, int chunkPosY) {
        content = new Square[15][15];
        this.chunkPosX = chunkPosX;
        this.chunkPosY = chunkPosY;
        fillWithGrass();
        addStonePatches();
    }

    public Square[][] getContent() {
        return content;
    }

    public int getChunkPosX() {
        return chunkPosX;
    }

    public int getChunkPosY() {
        return chunkPosY;
    }

    public Square getContentAtPos(int x, int y) {
        return content[x][y];
    }

    private void fillWithGrass() {
        String texture = "assets/textures/terrain/Herbe3.png";
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                Square grass = new Square(texture, x, y);
                content[x][y] = grass;
            }
        }
    }

    private void addFlowerPatches() {

    }

    private void addStonePatches() {
        String texture = "assets/textures/terrain/Caillou.png";
        for (int x = 0; x < 6; x++) {
            int[] randPos = {(int)(Math.random()*content.length), (int)(Math.random()*content.length)};
            Square stone = new Square(texture, randPos[0], randPos[1]);
            content[randPos[0]][randPos[1]] = stone;
        }
    }
}