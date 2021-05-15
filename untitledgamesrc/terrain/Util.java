package terrain;
/**
 * @author DELVIGNE Brian, DIOT Sébastien, GNALY-NGUYEN Kouadjo, LEHMAN Ylon
 * @version 16/05/2021
 */
public class Util {
    /**
     * Constructeur par initialisation
     * @param value double
     * @param start_input double
     * @param end_input double
     * @param start_output double
     * @param end_output double
     * @return double
     */
    public static double map(double value, double start_input, double end_input, double start_output, double end_output) {
        return start_output + ((end_output-start_output) / (end_input-start_input)) * (value-start_input);
    }
}