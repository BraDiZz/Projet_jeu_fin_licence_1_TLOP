package untitledgame.terrain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import untitledgame.personnages.*;
import untitledgame.texture.*;

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
        content[mob.squarePosY][mob.squarePosX].setMob(null);
        mob.squarePosX += direction.x;
        mob.squarePosY += direction.y;
        content[mob.squarePosY][mob.squarePosX].setMob(mob);
    }

    public void addPlayerAtPos(APersonnage mob, int squarePosX, int squarePosY) {
        content[squarePosX][squarePosY].setMob(mob);
    }


    public void fillWithGrass() {
        Texture texture = new Texture(TexturePath.GRASS3);
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                Square grass = new Square(texture, x, y);
                content[x][y] = grass;
            }
        }
    }

    public void addFeatures(Texture texture, int count) {
        for (int x = 0; x < count; x++) {
            int[] randPos = {(int)(Math.random()*content.length), (int)(Math.random()*content.length)};
            Square feature = new Square(texture, randPos[0], randPos[1]);
            content[randPos[0]][randPos[1]] = feature;
        }
    }

    public void perlinize(long seed, int scale, Texture texture) {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (Perlin.noise(Util.map(x+chunkPosY*15, 0, 15*4, 2, scale), Util.map(y+chunkPosX*15, 0, 15*4, 2, scale), seed) > 190) {
                    content[x][y] = new Square(texture, x, y);
                }
            }
        }
    }

    public void reversePerlinize(long seed, int scale, Texture texture) {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (Perlin.noise(Util.map(x+chunkPosY*15, 0, 15*4, 2, scale), Util.map(y+chunkPosX*15, 0, 15*4, 2, scale), seed) > 190) {
                    content[x][y] = new Square(texture, x, y);
                }
            }
        }
    }
}