package terrain;

import java.util.Random;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 10/05/2021
 */
public class Perlin {
    /**
     * Methode pour
     * @param x double
     * @return double
     */
    private static double fade(double x) {
        return(6*x*x*x*x*x-15*x*x*x*x+10*x*x*x);
    }
    /**
     * Methode pour 
     * @param a double
     * @param b double
     * @param x double
     * @return double
     */
    private static double lerp(double a, double b, double x) {
        return a*(1-fade(x))+b*fade(x);
    }
    /**
     * Methode pour 
     * @param x int
     * @param y int 
     * @param seed long
     * @return double 
     */
    private static double f(int x, int y, long seed) {
        return (new Random(seed + 25483l * (int)x + 251453l * (int)y)).nextInt(256);
    }
    /**
     * Methode pour 
     * @param xPoint double 
     * @param yPoint double 
     * @param seed long 
     * @return double
     */
    public static double noise(double xPoint, double yPoint, long seed) {
        int xMin = (int)Math.floor(xPoint);
        int yMin = (int)Math.floor(yPoint);
        int xMax = (int)Math.ceil(xPoint);
        int yMax = (int)Math.ceil(yPoint);

        double linearInter1 = lerp(f(xMin, yMin, seed) , f(xMin, yMax, seed), yPoint-yMin);
        double linearInter2 = lerp(f(xMax, yMin, seed), f(xMax, yMax, seed), yPoint-yMin);
        
        double linearInterFinal = lerp(linearInter1, linearInter2, xPoint-xMin);
        return linearInterFinal;
    }
}