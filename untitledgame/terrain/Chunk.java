package untitledgame.terrain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import untitledgame.personnages.*;

public class Chunk {
    private int chunkPosX;
    private int chunkPosY;
    private Square[][] content;

    public Chunk(int chunkPosX, int chunkPosY) {
        content = new Square[15][15];
        this.chunkPosX = chunkPosX;
        this.chunkPosY = chunkPosY;
        fillWithGrass();
    }

    public Square[][] getContent() {
        return content;
    }

    public Square getContentAtPos(int x, int y) {
        return content[x][y];
    }

    public int getChunkPosX() {
        return chunkPosX;
    }

    public int getChunkPosY() {
        return chunkPosY;
    }

    public void changeMobPos(APersonnage mob, Direction direction) {
        content[mob.squarePosY%15][mob.squarePosX%15].setMob(null);
        mob.squarePosX += direction.x;
        mob.squarePosY += direction.y;
        content[mob.squarePosY%15][mob.squarePosX%15].setMob(mob);
    }

    public void removeMobAtPos(int xSquare, int ySquare) {
        content[xSquare][ySquare].setMob(null);
    }

    public void setMobAtPos(APersonnage mob, int squarePosX, int squarePosY) {
        content[squarePosX][squarePosY].setMob(mob);
    }

    public void fillWithGrass() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                Square grass = new Square(SquareType.GRASS3, x, y);
                content[x][y] = grass;
            }
        }
    }

    public void addFeatures(SquareType squareType, int count) {
        for (int x = 0; x < count; x++) {
            int[] randPos = {(int)(Math.random()*content.length), (int)(Math.random()*content.length)};
            Square feature = new Square(squareType, randPos[0], randPos[1]);
            content[randPos[0]][randPos[1]] = feature;
        }
    }

    public void perlinize(SquareType squareType, long seed, int scale) {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (Perlin.noise(Util.map(x+chunkPosX*15, 0, 15*4, 2, scale), Util.map(y+chunkPosY*15, 0, 15*4, 2, scale), seed) > 190) {
                    content[x][y] = new Square(squareType, x, y);
                }
            }
        }
    }

    public void reversePerlinize(SquareType squareType, long seed, int scale) {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (Perlin.noise(Util.map(x+chunkPosX*15, 0, 15*4, 2, scale), Util.map(y+chunkPosY*15, 0, 15*4, 2, scale), seed) > 190) {
                    content[x][y] = new Square(squareType, x, y);
                }
            }
        }
    }
}