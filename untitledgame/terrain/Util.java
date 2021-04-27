package untitledgame.terrain;

public class Util {
    public static double map(double value, double start_input, double end_input, double start_output, double end_output) {
        return start_output + ((end_output-start_output) / (end_input-start_input)) * (value-start_input);
    }
}